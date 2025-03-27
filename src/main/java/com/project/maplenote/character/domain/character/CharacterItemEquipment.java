package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.item.ItemEquipment;
import com.project.maplenote.character.domain.character.item.MedalShape;
import com.project.maplenote.character.domain.character.item.Title;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 장착 장비 정보 (캐시 장비 제외)
 */
@Getter
@Setter
public class CharacterItemEquipment {

    @JsonProperty("date")
    private String date;  // 조회 기준일

    @JsonProperty("character_gender")
    private String characterGender;  // 캐릭터 성별

    @JsonProperty("character_class")
    private String characterClass;  // 캐릭터 직업

    @JsonProperty("preset_no")
    private int presetNo;  // 적용 중인 장비 프리셋 번호 (number)

    @JsonProperty("item_equipment")
    private List<ItemEquipment> itemEquipment;  // 장비 정보

    @JsonProperty("item_equipment_preset_1")
    private List<ItemEquipment> itemEquipmentPreset1;  // 1번 프리셋 장비 정보

    @JsonProperty("item_equipment_preset_2")
    private List<ItemEquipment> itemEquipmentPreset2;  // 2번 프리셋 장비 정보

    @JsonProperty("item_equipment_preset_3")
    private List<ItemEquipment> itemEquipmentPreset3;  // 3번 프리셋 장비 정보

    @JsonProperty("title")
    private Title title;  // 칭호 정보

    @JsonProperty("medal_shape")
    private MedalShape medalShape;  // 외형 설정에 등록한 훈장 외형 정보

}
