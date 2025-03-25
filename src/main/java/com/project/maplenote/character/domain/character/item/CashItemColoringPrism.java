package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashItemColoringPrism {

    @JsonProperty("color_range")
    private String colorRange; // 컬러링프리즘 색상 범위

    @JsonProperty("hue")
    private long hue; // 컬러링프리즘 색조

    @JsonProperty("saturation")
    private long saturation; // 컬러링프리즘 채도

    @JsonProperty("value")
    private long value; // 컬러링프리즘 명도
}
