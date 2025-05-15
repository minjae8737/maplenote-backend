package com.project.maplenote.character.domain.character;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 캐릭터 인기도
 */
@Getter
@Setter
@NoArgsConstructor
public class CharacterPopularity {
    private String date;     // 조회 기준일
    private long popularity;        // 인기도
}
