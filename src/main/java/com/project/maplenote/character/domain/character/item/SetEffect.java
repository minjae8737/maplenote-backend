package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SetEffect {

    @JsonProperty("set_name")
    private String setName; // 세트 효과 명

    @JsonProperty("total_set_count")
    private long totalSetCount; // 세트 개수 (럭키 아이템 포함)

    @JsonProperty("set_effect_info")
    private List<SetEffectInfo> setEffectInfo; // 적용 중인 세트 효과 정보

    @JsonProperty("set_effect_full_info")
    private List<SetEffectInfo> setEffectFullInfo; // 모든 세트 효과 정보

}
