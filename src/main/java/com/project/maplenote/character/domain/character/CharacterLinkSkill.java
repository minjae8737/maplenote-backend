package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.skill.LinkSkill;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterLinkSkill {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST)

    @JsonProperty("character_class")
    private String characterClass; // 캐릭터 직업

    @JsonProperty("character_link_skill")
    private List<LinkSkill> characterLinkSkill; // 일반 링크 스킬 목록

    @JsonProperty("character_link_skill_preset_1")
    private List<LinkSkill> characterLinkSkillPreset1; // 1번 프리셋 링크 스킬

    @JsonProperty("character_link_skill_preset_2")
    private List<LinkSkill> characterLinkSkillPreset2; // 2번 프리셋 링크 스킬

    @JsonProperty("character_link_skill_preset_3")
    private List<LinkSkill> characterLinkSkillPreset3; // 3번 프리셋 링크 스킬

    @JsonProperty("character_owned_link_skill")
    private LinkSkill characterOwnedLinkSkill; // 내 링크 스킬 정보

    @JsonProperty("character_owned_link_skill_preset_1")
    private LinkSkill characterOwnedLinkSkillPreset1; // 내 링크 스킬 1번 프리셋

    @JsonProperty("character_owned_link_skill_preset_2")
    private LinkSkill characterOwnedLinkSkillPreset2; // 내 링크 스킬 2번 프리셋

    @JsonProperty("character_owned_link_skill_preset_3")
    private LinkSkill characterOwnedLinkSkillPreset3; // 내 링크 스킬 3번 프리셋

}

