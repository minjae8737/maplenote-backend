package com.project.maplenote.character.domain.character.skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VCore {
    @JsonProperty("slot_id")
    private String slotId; // 슬롯 인덱스

    @JsonProperty("slot_level")
    private Long slotLevel; // 슬롯 레벨

    @JsonProperty("v_core_name")
    private String vCoreName; // 코어 명

    @JsonProperty("v_core_type")
    private String vCoreType; // 코어 타입

    @JsonProperty("v_core_level")
    private Long vCoreLevel; // 코어 레벨

    @JsonProperty("v_core_skill_1")
    private String vCoreSkill1; // 코어에 해당하는 첫 번째 스킬 명

    @JsonProperty("v_core_skill_2")
    private String vCoreSkill2; // (강화 코어인 경우) 두 번째 스킬 명

    @JsonProperty("v_core_skill_3")
    private String vCoreSkill3; // (강화 코어인 경우) 세 번째 스킬 명
}
