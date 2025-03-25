package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 장비 추가 옵션
 */
@Getter
@Setter
public class ItemAddOption {

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

    @JsonProperty("armor")
    private String armor;  // 방어력

    @JsonProperty("speed")
    private String speed;  // 이동속도

    @JsonProperty("jump")
    private String jump;  // 점프력

    @JsonProperty("boss_damage")
    private String bossDamage;  // 보스 공격 시 데미지 증가(%)

    @JsonProperty("damage")
    private String damage;  // 데미지(%)

    @JsonProperty("all_stat")
    private String allStat;  // 올스탯(%)

    @JsonProperty("equipment_level_decrease")
    private long equipmentLevelDecrease;  // 착용 레벨 감소

}
