package com.project.maplenote.character.domain.character.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 현재 스탯 정보
 */
@Getter
@Setter
public class FinalStat {

    @JsonProperty("stat_name")
    private String statName;    // 스탯 명

    @JsonProperty("stat_value")
    private String statValue;   // 스탯 값

}
