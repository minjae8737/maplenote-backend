package com.project.maplenote.character.domain.union.matrix;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UnionInnerStat {

    @JsonProperty("stat_field_id")
    private String statFieldId; // 공격대 배치 위치 (11시 방향부터 시계방향 0~7)

    @JsonProperty("stat_field_effect")
    private String statFieldEffect; // 해당 지역 점령 효과

}