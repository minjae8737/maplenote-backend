package com.project.maplenote.character.domain.character.skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HexaStatCore {

    @JsonProperty("slot_id")
    private String slotId; // 슬롯 인덱스

    @JsonProperty("main_stat_name")
    private String mainStatName; // 메인 스탯 명

    @JsonProperty("sub_stat_name_1")
    private String subStatName1; // 첫 번째 서브 명

    @JsonProperty("sub_stat_name_2")
    private String subStatName2; // 두 번째 서브 명

    @JsonProperty("main_stat_level")
    private Long mainStatLevel; // 메인 스탯 레벨

    @JsonProperty("sub_stat_level_1")
    private Long subStatLevel1; // 첫 번째 서브 레벨

    @JsonProperty("sub_stat_level_2")
    private Long subStatLevel2; // 두 번째 서브 레벨

    @JsonProperty("stat_grade")
    private Long statGrade; // 스탯 코어 등급

}
