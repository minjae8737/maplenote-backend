package com.project.maplenote.character.domain.character.stat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 어빌리티 프리셋
 */
@Getter
@Setter
@NoArgsConstructor
public class AbilityPreset {

    @JsonProperty("ability_preset_grade")
    private String abilityPresetGrade;        // 어빌리티 프리셋의 어빌리티 등급

    @JsonProperty("ability_info")
    private List<AbilityInfo> abilityInfo;     // 어빌리티 프리셋 정보

}
