package com.project.maplenote.character.domain.union.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChampionInfo {

    @JsonProperty("champion_name")
    private String championName; // 유니온 챔피언 캐릭터 명

    @JsonProperty("champion_slot")
    private Long championSlot; // 유니온 챔피언 슬롯 번호

    @JsonProperty("champion_grade")
    private String championGrade; // 유니온 챔피언 등급

    @JsonProperty("champion_class")
    private String championClass; // 유니온 챔피언 캐릭터의 직업

    @JsonProperty("champion_badge_info")
    private List<ChampionBadge> championBadgeInfo; // 챔피언 휘장 정보 리스트

}
