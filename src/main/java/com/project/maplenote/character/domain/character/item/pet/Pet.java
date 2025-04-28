package com.project.maplenote.character.domain.character.item.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Pet {
    @JsonProperty("name")
    private String name; // 펫 명

    @JsonProperty("nickname")
    private String nickname; // 펫 닉네임

    @JsonProperty("icon")
    private String icon; // 펫 아이콘

    @JsonProperty("description")
    private String description; // 펫 설명

    @JsonProperty("equipment")
    private PetEquipment equipment; // 펫 장착 아이템

    @JsonProperty("auto_skill")
    private PetAutoSkill autoSkill; // 펫 자동 버프 스킬

    @JsonProperty("pet_type")
    private String petType; // 원더 펫 종류

    @JsonProperty("skill")
    private List<String> skills; // 펫 보유 스킬 목록

    @JsonProperty("date_expire")
    private String dateExpire; // 마법의 시간 (expired: 만료, null: 무제한)

    @JsonProperty("appearance")
    private String appearance; // 펫 외형

    @JsonProperty("appearance_icon")
    private String appearanceIcon; // 펫 외형 아이콘

}