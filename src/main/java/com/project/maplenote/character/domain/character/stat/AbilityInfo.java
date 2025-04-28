package com.project.maplenote.character.domain.character.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 어빌리티 정보
 */
@Getter
@Setter
@NoArgsConstructor
public class AbilityInfo {

    @JsonProperty("ability_no")
    private String abilityNo;      // 어빌리티 번호

    @JsonProperty("ability_grade")
    private String abilityGrade;   // 어빌리티 등급

    @JsonProperty("ability_value")
    private String abilityValue;   // 어빌리티 옵션 및 수치
}
