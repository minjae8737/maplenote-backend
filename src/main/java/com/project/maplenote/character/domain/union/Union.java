package com.project.maplenote.character.domain.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Union {

    @JsonProperty("date")
    private String date;  //조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)

    @JsonProperty("union_level")
    private String unionLevel;  //유니온 레벨

    @JsonProperty("union_grade")
    private String unionGrade;  //유니온 등급

    @JsonProperty("union_artifact_level")
    private String unionArtifactLevel;  //아티팩트 레벨

    @JsonProperty("union_artifact_exp")
    private String unionArtifactExp;  //보유 아티팩트 경험치

    @JsonProperty("union_artifact_point")
    private String unionArtifactPoint;  //보유 아티팩트 포인트

}
