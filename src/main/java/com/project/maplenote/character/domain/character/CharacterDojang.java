package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CharacterDojang {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST)

    @JsonProperty("character_class")
    private String characterClass; // 캐릭터 직업

    @JsonProperty("world_name")
    private String worldName; // 월드 명

    @JsonProperty("dojang_best_floor")
    private Long dojangBestFloor; // 무릉도장 최고 기록 층수

    @JsonProperty("date_dojang_record")
    private String dateDojangRecord; // 무릉도장 최고 기록 달성 일 (KST)

    @JsonProperty("dojang_best_time")
    private Long dojangBestTime; // 무릉도장 최고 층수 클리어에 걸린 시간 (초)
}

