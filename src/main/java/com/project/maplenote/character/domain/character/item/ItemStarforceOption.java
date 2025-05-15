package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 장비 스타포스 옵션 정보
 */
@Getter
@Setter
@NoArgsConstructor
public class ItemStarforceOption {

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

}
