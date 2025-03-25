package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * 성향 정보 조회
 */
@Getter
@Setter
public class CharacterPropensity {

    @JsonProperty("date")
    private LocalDateTime date;  // 조회 기준일

    @JsonProperty("charisma_level")
    private int charismaLevel;  // 카리스마 레벨

    @JsonProperty("sensibility_level")
    private int sensibilityLevel;  // 감성 레벨

    @JsonProperty("insight_level")
    private int insightLevel;  // 통찰력 레벨

    @JsonProperty("willingness_level")
    private int willingnessLevel;  // 의지 레벨

    @JsonProperty("handicraft_level")
    private int handicraftLevel;  // 손재주 레벨

    @JsonProperty("charm_level")
    private int charmLevel;  // 매력 레벨

}
