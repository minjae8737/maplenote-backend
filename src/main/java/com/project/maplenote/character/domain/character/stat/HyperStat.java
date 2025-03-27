package com.project.maplenote.character.domain.character.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 하이퍼 스탯 정보
 */
@Getter
@Setter
public class HyperStat {

    @JsonProperty("stat_type")
    private String statType;           // 스탯 종류

    @JsonProperty("stat_point")
    private Long statPoint;          // 스탯 투자 포인트

    @JsonProperty("stat_level")
    private Long statLevel;          // 스탯 레벨

    @JsonProperty("stat_increase")
    private String statIncrease;       // 스탯 상승량

}
