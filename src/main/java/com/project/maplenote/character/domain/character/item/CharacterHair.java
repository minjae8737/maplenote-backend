package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterHair {
    @JsonProperty("hair_name")
    private String hairName; // 헤어 명

    @JsonProperty("base_color")
    private String baseColor; // 헤어 베이스 컬러

    @JsonProperty("mix_color")
    private String mixColor; // 헤어 믹스 컬러

    @JsonProperty("mix_rate")
    private String mixRate; // 헤어 믹스 컬러의 염색 비율
}
