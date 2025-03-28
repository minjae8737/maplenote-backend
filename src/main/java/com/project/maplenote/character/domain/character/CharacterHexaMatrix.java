package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.skill.HexaCore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterHexaMatrix {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST)

    @JsonProperty("character_hexa_core_equipment")
    private List<HexaCore> characterHexaCoreEquipment; // HEXA 코어 정보 목록

}

