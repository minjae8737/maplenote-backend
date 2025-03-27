package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterFace {
    @JsonProperty("face_name")
    private String faceName; // 성형 명

    @JsonProperty("base_color")
    private String baseColor; // 성형 베이스 컬러

    @JsonProperty("mix_color")
    private String mixColor; // 성형 믹스 컬러

    @JsonProperty("mix_rate")
    private String mixRate; // 성형 믹스 컬러의 염색 비율
}
