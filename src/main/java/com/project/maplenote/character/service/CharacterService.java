package com.project.maplenote.character.service;

import com.project.maplenote.character.domain.Dto.CharacterResponseDto;
import com.project.maplenote.character.domain.character.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.View;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class CharacterService {

    private final View error;
    @Value("${default.characterName}")
    String defaultcharacterName;

    String BASEURL = "/character";

    private final WebClient webClient;

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
        Mono<CharacterBasic> characterBasic = getCharacterBasic(ocid, date);
        Mono<CharacterPopularity> characterPopularity = getCharacterPopularity(ocid, date);
        Mono<CharacterStat> characterStat = getCharacterStat(ocid, date);
        Mono<CharacterItemEquipment> characterItemEquipment = getCharacterItemEquipment(ocid, date);

        return Mono.zip(characterBasic, characterPopularity, characterStat, characterItemEquipment)
                .map(objects -> new CharacterResponseDto(
                        objects.getT1(),
                        objects.getT2(),
                        objects.getT3()
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


}