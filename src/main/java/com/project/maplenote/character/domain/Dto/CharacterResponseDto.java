package com.project.maplenote.character.domain.Dto;

import com.project.maplenote.character.domain.character.CharacterBasic;
import com.project.maplenote.character.domain.character.CharacterPopularity;
import com.project.maplenote.character.domain.character.CharacterStat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterResponseDto {

    private CharacterBasic characterBasic;
    private CharacterPopularity characterPopularity;
    private CharacterStat characterStat;

    public CharacterResponseDto(CharacterBasic characterBasic, CharacterPopularity characterPopularity, CharacterStat characterStat) {
        this.characterBasic = characterBasic;
        this.characterPopularity = characterPopularity;
        this.characterStat = characterStat;
    }
}
