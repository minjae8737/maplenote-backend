package com.project.maplenote.character.domain.character.skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HexaSkill {

    @JsonProperty("hexa_skill_id")
    private String hexaSkillId; // HEXA 스킬 명

}
