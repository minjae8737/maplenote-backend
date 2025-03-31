package com.project.maplenote.character.service;

import com.project.maplenote.character.domain.Dto.CharacterResponseDto;
import com.project.maplenote.character.domain.character.*;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CharacterService {

    @Value("${default.characterName}")
    String defaultcharacterName;

    String BASEURL = "/character";

    private final WebClient webClient;

    @RateLimiter(name = "myRateLimiter")
    public Mono<CharacterResponseDto> getCharacterData(String characterName) {

        LocalDateTime nowDate = LocalDateTime.now();
        String defaultDate = nowDate.minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); // 당일은 조회 불가

        //FIXME 나중에 지울것
        characterName = defaultcharacterName;

        return getOcid(defaultcharacterName)
                .flatMap(characterOcid -> getCharacter(characterOcid.getOcid(), defaultDate)) // FIXME 나중에 date 입력받아서 넘길수도 있게 고치기
                .doOnSuccess(characterResponseDto -> log.info("############ Success get CharacterData"))
                .doOnError(error -> log.info("############ Fail get CharacterData : {}", error.getMessage()));
    }

    public Mono<CharacterResponseDto> getCharacter(String ocid, String date) {

        List<Mono<?>> monos = List.of(
                getCharacterBasic(ocid, date),
                getCharacterPopularity(ocid, date),
                getCharacterStat(ocid, date),
                getCharacterHyperStat(ocid, date),
                getCharacterPropensity(ocid, date),
                getCharacterAbility(ocid, date),
                getCharacterItemEquipment(ocid, date),
                getCharacterSymbolEquipment(ocid, date),
                getCharacterSetEffect(ocid, date),
                getCharacterCashItemEquipment(ocid, date),
                getCharacterBeautyEquipment(ocid, date),
                getCharacterAndroidEquipment(ocid, date),
                getCharacterPetEquipment(ocid, date),
                getCharacterSkills(ocid, date),
                getCharacterLinkSkill(ocid, date),
                getCharacterVMatrix(ocid, date),
                getCharacterHexaMatrix(ocid, date),
                getCharacterHexaMatrixStat(ocid, date),
                getCharacterDojang(ocid, date)
        );

        return Flux.fromIterable(monos)
                .concatMap(mono -> mono.delayElement(Duration.ofMillis(200))) // 순차 실행
                .collectList()
                .map(objects -> new CharacterResponseDto(
                        (CharacterBasic) objects.get(0),
                        (CharacterPopularity) objects.get(1),
                        (CharacterStat) objects.get(2),
                        (CharacterHyperStat) objects.get(3),
                        (CharacterPropensity) objects.get(4),
                        (CharacterAbility) objects.get(5),
                        (CharacterItemEquipment) objects.get(6),
                        (CharacterSymbolEquipment) objects.get(7),
                        (CharacterSetEffect) objects.get(8),
                        (CharacterCashItemEquipment) objects.get(9),
                        (CharacterBeautyEquipment) objects.get(10),
                        (CharacterAndroidEquipment) objects.get(11),
                        (CharacterPetEquipment) objects.get(12),
                        (CharacterSkills) objects.get(13),
                        (CharacterLinkSkill) objects.get(14),
                        (CharacterVMatrix) objects.get(15),
                        (CharacterHexaMatrix) objects.get(16),
                        (CharacterHexaMatrixStat) objects.get(17),
                        (CharacterDojang) objects.get(18)
                ));
    }

    public Mono<CharacterOcid> getOcid(String characterName) {
        String url = "/id";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("character_name", defaultcharacterName) // FIXME defaultcharacterName 바꿔야함
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterOcid.class)
                .onErrorResume(e -> {
                    log.info("Ocid Not Found : " + e.getMessage());
                    return Mono.empty();
                });
    }

    public Mono<CharacterBasic> getCharacterBasic(String ocid, String date) {
        String url = BASEURL + "/basic";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterBasic.class);
    }

    public Mono<CharacterPopularity> getCharacterPopularity(String ocid, String date) {
        String url = BASEURL + "/popularity";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterPopularity.class);
    }

    public Mono<CharacterStat> getCharacterStat(String ocid, String date) {
        String url = BASEURL + "/stat";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterStat.class);
    }

    public Mono<CharacterHyperStat> getCharacterHyperStat(String ocid, String date) {
        String url = BASEURL + "/hyper-stat";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterHyperStat.class);
    }

    public Mono<CharacterPropensity> getCharacterPropensity(String ocid, String date) {
        String url = BASEURL + "/propensity";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterPropensity.class);
    }

    public Mono<CharacterAbility> getCharacterAbility(String ocid, String date) {
        String url = BASEURL + "/propensity";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterAbility.class);
    }

    public Mono<CharacterItemEquipment> getCharacterItemEquipment(String ocid, String date) {
        String url = BASEURL + "/item-equipment";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterItemEquipment.class);
    }

    public Mono<CharacterSymbolEquipment> getCharacterSymbolEquipment(String ocid, String date) {
        String url = BASEURL + "/symbol-equipment";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterSymbolEquipment.class);
    }

    public Mono<CharacterSetEffect> getCharacterSetEffect(String ocid, String date) {
        String url = BASEURL + "/set-effect";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterSetEffect.class);
    }

    public Mono<CharacterCashItemEquipment> getCharacterCashItemEquipment(String ocid, String date) {
        String url = BASEURL + "/cashitem-equipment";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterCashItemEquipment.class);
    }

    public Mono<CharacterBeautyEquipment> getCharacterBeautyEquipment(String ocid, String date) {
        String url = BASEURL + "/beauty-equipment";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterBeautyEquipment.class);
    }


    public Mono<CharacterAndroidEquipment> getCharacterAndroidEquipment(String ocid, String date) {
        String url = BASEURL + "/android-equipment";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterAndroidEquipment.class);
    }

    public Mono<CharacterPetEquipment> getCharacterPetEquipment(String ocid, String date) {
        String url = BASEURL + "/pet-equipment";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterPetEquipment.class);
    }

    public Mono<CharacterSkills> getCharacterSkills(String ocid, String date) {
        List<String> SKILLGRAGELIST = List.of("0", "1", "1.5", "2", "2.5", "3", "4", "hyperpassive", "hyperactive", "5", "6");

        return Flux.fromIterable(SKILLGRAGELIST)
                .delayElements(Duration.ofMillis(200))
                .concatMap(skillGrade -> getCharacterSkill(ocid, date, skillGrade))
                .collectList()
                .map(characterSkills -> new CharacterSkills(characterSkills));
    }

    public Mono<CharacterSkill> getCharacterSkill(String ocid, String date, String skillGrade) {
        String url = BASEURL + "/skill";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .queryParam("character_skill_grade", skillGrade)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterSkill.class);
    }

    public Mono<CharacterLinkSkill> getCharacterLinkSkill(String ocid, String date) {
        String url = BASEURL + "/link-skill";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterLinkSkill.class);
    }

    public Mono<CharacterVMatrix> getCharacterVMatrix(String ocid, String date) {
        String url = BASEURL + "/vmatrix";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterVMatrix.class);
    }

    public Mono<CharacterHexaMatrix> getCharacterHexaMatrix(String ocid, String date) {
        String url = BASEURL + "/hexamatrix";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterHexaMatrix.class);
    }

    public Mono<CharacterHexaMatrixStat> getCharacterHexaMatrixStat(String ocid, String date) {
        String url = BASEURL + "/hexamatrix-stat";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterHexaMatrixStat.class);
    }

    public Mono<CharacterDojang> getCharacterDojang(String ocid, String date) {
        String url = BASEURL + "/dojang";

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .queryParam("ocid", ocid)
                        .queryParam("date", date)
                        .build()
                )
                .retrieve()
                .bodyToMono(CharacterDojang.class);
    }

}