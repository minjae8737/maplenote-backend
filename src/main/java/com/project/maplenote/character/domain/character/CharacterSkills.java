package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CharacterSkills {

    @JsonProperty("character_skill_list")
    private List<CharacterSkill> characterSkillList;

    public CharacterSkills(List<CharacterSkill> characterSkillList) {
        this.characterSkillList = characterSkillList;
    }
}
