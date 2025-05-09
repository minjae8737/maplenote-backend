package com.project.maplenote.character.domain.Dto;

import com.project.maplenote.character.domain.character.*;
import com.project.maplenote.character.domain.union.Union;
import com.project.maplenote.character.domain.union.UnionArtifact;
import com.project.maplenote.character.domain.union.UnionChampion;
import com.project.maplenote.character.domain.union.UnionRaider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
    private CharacterBeautyEquipment characterBeautyEquipment;
    private CharacterAndroidEquipment characterAndroidEquipment;
    private CharacterPetEquipment characterPetEquipment;
    private CharacterSkills characterSkills;
    private CharacterLinkSkill characterLinkSkill;
    private CharacterVMatrix characterVMatrix;
    private CharacterHexaMatrix characterHexaMatrix;
    private CharacterHexaMatrixStat characterHexaMatrixStat;
    private CharacterDojang characterDojang;
    private List<CharacterExp> characterExps;
    private Union union;
    private UnionRaider unionRaider;
    private UnionArtifact unionArtifact;
    private UnionChampion unionChampion;

    public CharacterResponseDto(CharacterBasic characterBasic, CharacterPopularity characterPopularity, CharacterStat characterStat, CharacterHyperStat characterHyperStat, CharacterPropensity characterPropensity, CharacterAbility characterAbility, CharacterItemEquipment characterItemEquipment, CharacterSymbolEquipment characterSymbolEquipment, CharacterSetEffect characterSetEffect, CharacterCashItemEquipment characterCashItemEquipment, CharacterBeautyEquipment characterBeautyEquipment, CharacterAndroidEquipment characterAndroidEquipment, CharacterPetEquipment characterPetEquipment, CharacterSkills characterSkills, CharacterLinkSkill characterLinkSkill, CharacterVMatrix characterVMatrix, CharacterHexaMatrix characterHexaMatrix, CharacterHexaMatrixStat characterHexaMatrixStat, CharacterDojang characterDojang, List<CharacterExp> characterExps, Union union, UnionRaider unionRaider, UnionArtifact unionArtifact, UnionChampion unionChampion) {
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
        this.characterBeautyEquipment = characterBeautyEquipment;
        this.characterAndroidEquipment = characterAndroidEquipment;
        this.characterPetEquipment = characterPetEquipment;
        this.characterSkills = characterSkills;
        this.characterLinkSkill = characterLinkSkill;
        this.characterVMatrix = characterVMatrix;
        this.characterHexaMatrix = characterHexaMatrix;
        this.characterHexaMatrixStat = characterHexaMatrixStat;
        this.characterDojang = characterDojang;
        this.characterExps = characterExps;
        this.union = union;
        this.unionRaider = unionRaider;
        this.unionArtifact = unionArtifact;
        this.unionChampion = unionChampion;
    }
}
