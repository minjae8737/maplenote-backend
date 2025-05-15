package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemTotalOption {

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

    @JsonProperty("ignore_monster_armor")
    private String ignoreMonsterArmor;  // 몬스터 방어율 무시(%)

    @JsonProperty("all_stat")
    private String allStat;  // 올스탯(%)

    @JsonProperty("damage")
    private String damage;  // 데미지(%)

    @JsonProperty("equipment_level_decrease")
    private Long equipmentLevelDecrease;  // 착용 레벨 감소

    @JsonProperty("max_hp_rate")
    private String maxHpRate;  // 최대 HP(%)

    @JsonProperty("max_mp_rate")
    private String maxMpRate;  // 최대 MP(%)

}
