package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOption {

    @JsonProperty("option_type")
    private String optionType; // 옵션 타입

    @JsonProperty("option_value")
    private String optionValue; // 옵션 값
}
