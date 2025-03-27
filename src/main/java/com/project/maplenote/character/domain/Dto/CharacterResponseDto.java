package com.project.maplenote.character.domain.Dto;

import com.project.maplenote.character.domain.character.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterResponseDto {

    private CharacterBasic characterBasic;
    private CharacterPopularity characterPopularity;
    private CharacterStat characterStat;
    private CharacterHyperStat characterHyperStat;
    private CharacterPropensity characterPropensity;
    private CharacterAbility characterAbility;
    private CharacterItemEquipment characterItemEquipment;
    private CharacterSymbolEquipment characterSymbolEquipment;
    private CharacterSetEffect characterSetEffect;
    private CharacterCashItemEquipment characterCashItemEquipment;

    public CharacterResponseDto(CharacterBasic characterBasic, CharacterPopularity characterPopularity, CharacterStat characterStat, CharacterHyperStat characterHyperStat, CharacterPropensity characterPropensity, CharacterAbility characterAbility, CharacterItemEquipment characterItemEquipment, CharacterSymbolEquipment characterSymbolEquipment, CharacterSetEffect characterSetEffect, CharacterCashItemEquipment characterCashItemEquipment) {
        this.characterBasic = characterBasic;
        this.characterPopularity = characterPopularity;
        this.characterStat = characterStat;
        this.characterHyperStat = characterHyperStat;
        this.characterPropensity = characterPropensity;
        this.characterAbility = characterAbility;
        this.characterItemEquipment = characterItemEquipment;
        this.characterSymbolEquipment = characterSymbolEquipment;
        this.characterSetEffect = characterSetEffect;
        this.characterCashItemEquipment = characterCashItemEquipment;
    }
}
