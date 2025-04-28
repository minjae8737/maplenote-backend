package com.project.maplenote.character.domain.character.item.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PetAutoSkill {
    @JsonProperty("skill_1")
    private String skill1; // 첫 번째 자동 스킬

    @JsonProperty("skill_1_icon")
    private String skill1Icon; // 첫 번째 자동 스킬 아이콘

    @JsonProperty("skill_2")
    private String skill2; // 두 번째 자동 스킬

    @JsonProperty("skill_2_icon")
    private String skill2Icon; // 두 번째 자동 스킬 아이콘
}