package com.project.maplenote.character.domain.character.skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HexaCore {

    @JsonProperty("hexa_core_name")
    private String hexaCoreName; // 코어 명

    @JsonProperty("hexa_core_level")
    private Long hexaCoreLevel; // 코어 레벨

    @JsonProperty("hexa_core_type")
    private String hexaCoreType; // 코어 타입

    @JsonProperty("linked_skill")
    private List<HexaSkill> linkedSkill; // 연결된 스킬 목록

}