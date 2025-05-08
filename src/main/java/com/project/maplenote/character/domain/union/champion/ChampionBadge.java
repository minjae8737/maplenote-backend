package com.project.maplenote.character.domain.union.champion;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChampionBadge {

    @JsonProperty("stat")
    private String stat; // 챔피언 휘장 효과 정보

}