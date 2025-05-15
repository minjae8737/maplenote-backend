package com.project.maplenote.character.domain.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.union.champion.ChampionBadge;
import com.project.maplenote.character.domain.union.champion.ChampionInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UnionChampion {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST, 일 단위, 시·분은 0으로 표기)

    @JsonProperty("union_champion")
    private List<ChampionInfo> unionChampion; // 유니온 챔피언 정보 리스트

    @JsonProperty("champion_badge_total_info")
    private List<ChampionBadge> championBadgeTotalInfo; // 전체 챔피언 휘장 효과 리스트

}

