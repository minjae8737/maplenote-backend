package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.stat.FinalStat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 종합 능력치 정보
 */
@Getter
@Setter
@NoArgsConstructor
public class CharacterStat {

    @JsonProperty("date")
    private String date;  // 조회 기준일

    @JsonProperty("character_class")
    private String characterClass;  // 캐릭터 직업

    @JsonProperty("final_stat")
    private List<FinalStat> finalStat;  // 현재 스탯 정보

    @JsonProperty("remain_ap")
    private long remainAp;  // 잔여 AP

}
