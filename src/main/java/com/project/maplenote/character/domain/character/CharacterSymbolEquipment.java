package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.item.Symbol;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 장착 심볼 정보
 */
@Getter
@Setter
@NoArgsConstructor
public class CharacterSymbolEquipment {

    @JsonProperty("date")
    private String date;  // 조회 기준일

    @JsonProperty("character_class")
    private String characterClass;  // 캐릭터 직업

    @JsonProperty("symbol")
    private List<Symbol> symbol;  // 심볼 정보

}
