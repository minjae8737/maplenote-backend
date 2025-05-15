package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.skill.VCore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CharacterVMatrix {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST)

    @JsonProperty("character_class")
    private String characterClass; // 캐릭터 직업

    @JsonProperty("character_v_core_equipment")
    private List<VCore> characterVCoreEquipment; // V코어 정보 목록

    @JsonProperty("character_v_matrix_remain_slot_upgrade_point")
    private Long characterVMatrixRemainSlotUpgradePoint; // 캐릭터 잔여 매트릭스 강화 포인트

}

