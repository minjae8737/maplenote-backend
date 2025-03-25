package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.stat.AbilityInfo;
import com.project.maplenote.character.domain.character.stat.AbilityPreset;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 캐릭터 어빌리티
 */
@Getter
@Setter
public class CharacterAbility {

    @JsonProperty("date")
    private LocalDateTime date;  // 조회 기준일

    @JsonProperty("ability_grade")
    private String abilityGrade;  // 어빌리티 등급

    @JsonProperty("ability_info")
    private List<AbilityInfo> abilityInfo;  // 어빌리티 정보

    @JsonProperty("remain_fame")
    private long remainFame;  // 보유 명성치

    @JsonProperty("preset_no")
    private int presetNo;  // 적용 중인 어빌리티 프리셋 번호

    @JsonProperty("ability_preset_1")
    private List<AbilityPreset> abilityPreset1;  // 어빌리티 1번 프리셋 전체 정보

    @JsonProperty("ability_preset_2")
    private List<AbilityPreset> abilityPreset2;  // 어빌리티 2번 프리셋 전체 정보

    @JsonProperty("ability_preset_3")
    private List<AbilityPreset> abilityPreset3;  // 어빌리티 3번 프리셋 전체 정보

}
