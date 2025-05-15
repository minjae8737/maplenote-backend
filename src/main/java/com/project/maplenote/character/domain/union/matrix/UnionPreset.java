package com.project.maplenote.character.domain.union.matrix;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UnionPreset {

    @JsonProperty("union_raider_stat")
    private List<String> unionRaiderStat; // 프리셋 내 유니온 공격대원 효과

    @JsonProperty("union_occupied_stat")
    private List<String> unionOccupiedStat; // 프리셋 내 점령 효과

    @JsonProperty("union_inner_stat")
    private List<UnionInnerStat> unionInnerStat; // 프리셋 내 공격대 배치 정보

    @JsonProperty("union_block")
    private List<UnionBlock> unionBlock; // 프리셋 내 유니온 블록 정보

}
