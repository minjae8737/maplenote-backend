package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.skill.HexaStatCore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CharacterHexaMatrixStat {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST)

    @JsonProperty("character_class")
    private String characterClass; // 캐릭터 직업

    @JsonProperty("character_hexa_stat_core")
    private List<HexaStatCore> characterHexaStatCore; // HEXA 스탯 I 코어 정보

    @JsonProperty("character_hexa_stat_core_2")
    private List<HexaStatCore> characterHexaStatCore2; // HEXA 스탯 II 코어 정보

    @JsonProperty("character_hexa_stat_core_3")
    private List<HexaStatCore> characterHexaStatCore3; // HEXA 스탯 III 코어 정보

    @JsonProperty("preset_hexa_stat_core")
    private List<HexaStatCore> presetHexaStatCore; // 프리셋 HEXA 스탯 I 코어 정보

    @JsonProperty("preset_hexa_stat_core_2")
    private List<HexaStatCore> presetHexaStatCore2; // 프리셋 HEXA 스탯 II 코어 정보

    @JsonProperty("preset_hexa_stat_core_3")
    private List<HexaStatCore> presetHexaStatCore3; // 프리셋 HEXA 스탯 III 코어 정보

}