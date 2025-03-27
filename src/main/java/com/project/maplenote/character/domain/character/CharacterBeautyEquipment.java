package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.item.CharacterFace;
import com.project.maplenote.character.domain.character.item.CharacterHair;
import com.project.maplenote.character.domain.character.item.CharacterSkin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterBeautyEquipment {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST)

    @JsonProperty("character_gender")
    private String characterGender; // 캐릭터 성별

    @JsonProperty("character_class")
    private String characterClass; // 캐릭터 직업

    @JsonProperty("character_hair")
    private CharacterHair characterHair; // 캐릭터 헤어 정보

    @JsonProperty("character_face")
    private CharacterFace characterFace; // 캐릭터 성형 정보

    @JsonProperty("character_skin")
    private CharacterSkin characterSkin; // 캐릭터 피부 정보

    @JsonProperty("additional_character_hair")
    private CharacterHair additionalCharacterHair; // (제로: 베타, 엔젤릭버스터: 드레스업 모드 헤어 정보)

    @JsonProperty("additional_character_face")
    private CharacterFace additionalCharacterFace; // (제로: 베타, 엔젤릭버스터: 드레스업 모드 성형 정보)

    @JsonProperty("additional_character_skin")
    private CharacterSkin additionalCharacterSkin; // (제로: 베타, 엔젤릭버스터: 드레스업 모드 피부 정보)

}
