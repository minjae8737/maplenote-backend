package com.project.maplenote.character.controller;

import com.project.maplenote.character.domain.Dto.CharacterResponseDto;
import com.project.maplenote.character.domain.character.CharacterOcid;
import com.project.maplenote.character.service.CharacterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/character")
@RequiredArgsConstructor
@Slf4j
public class CharacterApiController {

    private final CharacterService characterService;

    @GetMapping("/{characterName}")
    public Mono<CharacterResponseDto> findCharacterData(@PathVariable String characterName) {
        log.info("############## findCharacterData : {}", characterName);
        return characterService.getCharacterData(characterName);
    }
}
