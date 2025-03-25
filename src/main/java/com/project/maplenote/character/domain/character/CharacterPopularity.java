package com.project.maplenote.character.domain.character;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 캐릭터 인기도
 */
@Getter
@Setter
public class CharacterPopularity {
    private LocalDateTime date;     // 조회 기준일
    private long popularity;        // 인기도
}
