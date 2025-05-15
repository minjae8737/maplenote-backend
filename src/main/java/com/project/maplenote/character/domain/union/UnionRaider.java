package com.project.maplenote.character.domain.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.union.matrix.UnionBlock;
import com.project.maplenote.character.domain.union.matrix.UnionInnerStat;
import com.project.maplenote.character.domain.union.matrix.UnionPreset;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UnionRaider {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST, 시·분은 0으로 표기)

    @JsonProperty("union_raider_stat")
    private List<String> unionRaiderStat; // 유니온 공격대원 효과

    @JsonProperty("union_occupied_stat")
    private List<String> unionOccupiedStat; // 유니온 공격대 점령 효과

    @JsonProperty("union_inner_stat")
    private List<UnionInnerStat> unionInnerStat; // 유니온 공격대 배치 정보

    @JsonProperty("union_block")
    private List<UnionBlock> unionBlock; // 유니온 블록 정보

    @JsonProperty("use_preset_no")
    private Long usePresetNo; // 현재 적용 중인 프리셋 번호

    @JsonProperty("union_raider_preset_1")
    private UnionPreset unionRaiderPreset1; // 프리셋 1번 정보

    @JsonProperty("union_raider_preset_2")
    private UnionPreset unionRaiderPreset2; // 프리셋 2번 정보

    @JsonProperty("union_raider_preset_3")
    private UnionPreset unionRaiderPreset3; // 프리셋 3번 정보

    @JsonProperty("union_raider_preset_4")
    private UnionPreset unionRaiderPreset4; // 프리셋 4번 정보

    @JsonProperty("union_raider_preset_5")
    private UnionPreset unionRaiderPreset5; // 프리셋 5번 정보

}
