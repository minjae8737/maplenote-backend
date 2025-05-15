package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.skill.Skill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CharacterSkill {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST)

    @JsonProperty("character_class")
    private String characterClass; // 캐릭터 직업

    @JsonProperty("character_skill_grade")
    private String characterSkillGrade; // 스킬 전직 차수

    @JsonProperty("character_skill")
    private List<Skill> characterSkill; // 스킬 목록

}

