package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.item.pet.Pet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterPetEquipment {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST)

    @JsonProperty("pet_1")
    private Pet pet1; // 펫1 정보

    @JsonProperty("pet_2")
    private Pet pet2; // 펫2 정보

    @JsonProperty("pet_3")
    private Pet pet3; // 펫3 정보

}
