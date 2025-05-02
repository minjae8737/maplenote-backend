package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.item.pet.PetAutoSkill;
import com.project.maplenote.character.domain.character.item.pet.PetEquipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CharacterPetEquipment {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST)

    @JsonProperty("pet_1_name")
    private String pet1Name; // 펫 명

    @JsonProperty("pet_1_nickname")
    private String pet1Nickname; // 펫 닉네임

    @JsonProperty("pet_1_icon")
    private String pet1Icon; // 펫 아이콘

    @JsonProperty("pet_1_description")
    private String pet1Description; // 펫 설명

    @JsonProperty("pet_1_equipment")
    PetEquipment pet1Equipment; // 펫 장착 정보

    @JsonProperty("pet_1_auto_skill")
    PetAutoSkill pet1AutoSkill; // 펫 버프 자동스킬 정보

    @JsonProperty("pet_1_pet_type")
    private String pet1PetType; // 원더 펫 종류

    @JsonProperty("pet_1_skill")
    private List<String> pet1Skill; // 펫 보유 스킬

    @JsonProperty("pet_1_date_expire")
    private String pet1DateExpire; // 마법의 시간 (expired:만료, null:무제한) (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)

    @JsonProperty("pet_1_appearance")
    private String pet1Appearance; // 펫 외형

    @JsonProperty("pet_1_appearance_icon")
    private String pet1AppearanceIcon; // 펫 외형 아이콘

    @JsonProperty("pet_2_name")
    private String pet2Name; // 펫 명

    @JsonProperty("pet_2_nickname")
    private String pet2Nickname; // 펫 닉네임

    @JsonProperty("pet_2_icon")
    private String pet2Icon; // 펫 아이콘

    @JsonProperty("pet_2_description")
    private String pet2Description; // 펫 설명

    @JsonProperty("pet_2_equipment")
    PetEquipment pet2Equipment; // 펫 장착 정보

    @JsonProperty("pet_2_auto_skill")
    PetAutoSkill pet2AutoSkill; // 펫 버프 자동스킬 정보

    @JsonProperty("pet_2_pet_type")
    private String pet2PetType; // 원더 펫 종류

    @JsonProperty("pet_2_skill")
    private List<String> pet2Skill; // 펫 보유 스킬

    @JsonProperty("pet_2_date_expire")
    private String pet2DateExpire; // 마법의 시간 (expired:만료, null:무제한) (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)

    @JsonProperty("pet_2_appearance")
    private String pet2Appearance; // 펫 외형

    @JsonProperty("pet_2_appearance_icon")
    private String pet2AppearanceIcon; // 펫 외형 아이콘

    @JsonProperty("pet_3_name")
    private String pet3Name; // 펫 명

    @JsonProperty("pet_3_nickname")
    private String pet3Nickname; // 펫 닉네임

    @JsonProperty("pet_3_icon")
    private String pet3Icon; // 펫 아이콘

    @JsonProperty("pet_3_description")
    private String pet3Description; // 펫 설명

    @JsonProperty("pet_3_equipment")
    PetEquipment pet3Equipment; // 펫 장착 정보

    @JsonProperty("pet_3_auto_skill")
    PetAutoSkill pet3AutoSkill; // 펫 버프 자동스킬 정보

    @JsonProperty("pet_3_pet_type")
    private String pet3PetType; // 원더 펫 종류

    @JsonProperty("pet_3_skill")
    private List<String> pet3Skill; // 펫 보유 스킬

    @JsonProperty("pet_3_date_expire")
    private String pet3DateExpire; // 마법의 시간 (expired:만료, null:무제한) (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)

    @JsonProperty("pet_3_appearance")
    private String pet3Appearance; // 펫 외형

    @JsonProperty("pet_3_appearance_icon")
    private String pet3AppearanceIcon; // 펫 외형 아이콘

}
