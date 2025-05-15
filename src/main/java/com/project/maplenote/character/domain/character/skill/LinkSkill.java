package com.project.maplenote.character.domain.character.skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LinkSkill {

    @JsonProperty("skill_name")
    private String skillName; // 스킬 명

    @JsonProperty("skill_description")
    private String skillDescription; // 스킬 설명

    @JsonProperty("skill_level")
    private Long skillLevel; // 스킬 레벨

    @JsonProperty("skill_effect")
    private String skillEffect; // 현재 스킬 효과

    @JsonProperty("skill_effect_next")
    private String skillEffectNext; // 다음 레벨 효과 (프리셋에는 없음)

    @JsonProperty("skill_icon")
    private String skillIcon; // 스킬 아이콘

}
