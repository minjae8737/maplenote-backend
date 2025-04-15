package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
public class CharacterExp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ocid;

    @Column(nullable = false)
    @JsonProperty("date")
    private String date;

    @Column(nullable = false)
    @JsonProperty("character_level")
    private Integer characterLevel; //캐릭터 레벨

    @Column(nullable = false)
    @JsonProperty("character_exp")
    private Long characterExp; //현재 레벨에서 보유한 경험치

    @Column(nullable = false)
    @JsonProperty("character_exp_rate")
    private String characterExpRate; //현재 레벨에서 경험치 퍼센트

    public CharacterExp() {

    }

    public CharacterExp(Long id, String ocid, String date, Integer characterLevel, Long characterExp, String characterExpRate) {
        this.id = id;
        this.ocid = ocid;
        this.date = date;
        this.characterLevel = characterLevel;
        this.characterExp = characterExp;
        this.characterExpRate = characterExpRate;
    }

    public CharacterExp(String ocid, String date, Integer characterLevel, Long characterExp, String characterExpRate) {
        this.ocid = ocid;
        this.date = date.substring(0, 9);
        this.characterLevel = characterLevel;
        this.characterExp = characterExp;
        this.characterExpRate = characterExpRate;
    }
}
