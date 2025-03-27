package com.project.maplenote.character.controller;

import com.project.maplenote.character.domain.Dto.CharacterResponseDto;
import com.project.maplenote.character.domain.character.CharacterOcid;
import com.project.maplenote.character.service.CharacterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
@Slf4j
public class CharacterApiController {

    private final CharacterService characterService;

    @GetMapping("")
    public Mono<CharacterResponseDto> findCharacterData(String CharacterName) {
        log.info("##############findCharacterData");
        return characterService.getCharacterData("알쟁이");
    }
}
