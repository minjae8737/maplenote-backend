package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CharacterSkin {
    @JsonProperty("skin_name")
    private String skinName; // 피부 명

    @JsonProperty("color_style")
    private String colorStyle; // 색상 계열

    @JsonProperty("hue")
    private long hue; // 피부 색조

    @JsonProperty("saturation")
    private long saturation; // 피부 채도

    @JsonProperty("brightness")
    private long brightness; // 피부 명도
}
