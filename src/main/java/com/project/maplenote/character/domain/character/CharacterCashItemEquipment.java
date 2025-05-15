package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.item.CashItemEquipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 장착 캐시 장비 정보
 */
@Getter
@Setter
@NoArgsConstructor
public class CharacterCashItemEquipment {

    @JsonProperty("date")
    private String date;  // 조회 기준일

    @JsonProperty("character_gender")
    private String characterGender;  // 캐릭터 성별

    @JsonProperty("character_class")
    private String characterClass;  // 캐릭터 직업

    @JsonProperty("character_look_mode")
    private String characterLookMode;

    @JsonProperty("preset_no")
    private int presetNo;  // 적용 중인 장비 프리셋 번호 (number)

    @JsonProperty("cash_item_equipment_base")
    private List<CashItemEquipment> cashItemEquipmentBase;

    @JsonProperty("cash_item_equipment_preset_1")
    private List<CashItemEquipment> cashItemEquipmentPreset1;   // 1번 코디 프리셋

    @JsonProperty("cash_item_equipment_preset_2")
    private List<CashItemEquipment> cashItemEquipmentPreset2;  // 2번 코디 프리셋

    @JsonProperty("cash_item_equipment_preset_3")
    private List<CashItemEquipment> cashItemEquipmentPreset3; // 3번 코디 프리셋

    @JsonProperty("additional_cash_item_equipment_base")
    private List<CashItemEquipment> additionalCashItemEquipmentBase;  // 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에서 장착 중인 캐시 장비

    @JsonProperty("additional_cash_item_equipment_preset_1")
    private List<CashItemEquipment> additionalCashItemEquipmentPreset1;  // 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 1번 코디 프리셋

    @JsonProperty("additional_cash_item_equipment_preset_2")
    private List<CashItemEquipment> additionalCashItemEquipmentPreset2;  // 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 2번 코디 프리셋

    @JsonProperty("additional_cash_item_equipment_preset_3")
    private List<CashItemEquipment> additionalCashItemEquipmentPreset3;  // 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 3번 코디 프리셋

}
