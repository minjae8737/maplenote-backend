package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 장비 특별 옵션 정보
 */
@Getter
@Setter
public class ItemExceptionalOption {

    @JsonProperty("str")
    private String strStat;  // STR

    @JsonProperty("dex")
    private String dexStat;  // DEX

    @JsonProperty("int")
    private String intStat;  // INT

    @JsonProperty("luk")
    private String lukStat;  // LUK

    @JsonProperty("max_hp")
    private String maxHp;  // 최대 HP

    @JsonProperty("max_mp")
    private String maxMp;  // 최대 MP

    @JsonProperty("attack_power")
    private String attackPower;  // 공격력

    @JsonProperty("magic_power")
    private String magicPower;  // 마력

    @JsonProperty("exceptional_upgrade")
    private long exceptionalUpgrade;  // 익셉셔널 강화 적용 횟수

}
