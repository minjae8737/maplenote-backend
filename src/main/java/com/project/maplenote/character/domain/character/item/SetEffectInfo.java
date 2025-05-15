package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 세트 효과 정보
 */
@Getter
@Setter
@NoArgsConstructor
public class SetEffectInfo {

    @JsonProperty("set_count")
    private long setCount; // 세트 효과 레벨 (장비 수)

    @JsonProperty("set_option")
    private String setOption; // 세트 효과

}
