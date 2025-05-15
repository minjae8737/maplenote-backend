package com.project.maplenote.character.domain.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.union.artifact.ArtifactCrystal;
import com.project.maplenote.character.domain.union.artifact.ArtifactEffect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UnionArtifact {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST, 일 단위, 시·분은 0으로 표기)

    @JsonProperty("union_artifact_effect")
    private List<ArtifactEffect> unionArtifactEffect; // 아티팩트 효과 정보 리스트

    @JsonProperty("union_artifact_crystal")
    private List<ArtifactCrystal> unionArtifactCrystal; // 아티팩트 크리스탈 정보 리스트

    @JsonProperty("union_artifact_remain_ap")
    private Long unionArtifactRemainAp; // 잔여 아티팩트 AP

}