package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.stat.HyperStat;
import lombok.Getter;
import lombok.Setter;

/**
 * 캐릭터 하이퍼 스탯
 */
@Getter
@Setter
public class CharacterHyperStat {

    @JsonProperty("date")
    private String date;  // 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)

    @JsonProperty("character_class")
    private String characterClass;  // 캐릭터 직업

    @JsonProperty("use_preset_no")
    private String usePresetNo;  // 적용 중인 프리셋 번호

    @JsonProperty("use_available_hyper_stat")
    private int useAvailableHyperStat;  // 사용 가능한 최대 하이퍼스탯 포인트

    @JsonProperty("hyper_stat_preset_1")
    private HyperStat hyperStatPreset1;  // 1번 프리셋 하이퍼 스탯 정보

    @JsonProperty("hyper_stat_preset_1_remain_point")
    private long hyperStatPreset1RemainPoint;  // 1번 프리셋 하이퍼 스탯 잔여 포인트

    @JsonProperty("hyper_stat_preset_2")
    private HyperStat hyperStatPreset2;  // 2번 프리셋 하이퍼 스탯 정보

    @JsonProperty("hyper_stat_preset_2_remain_point")
    private long hyperStatPreset2RemainPoint;  // 2번 프리셋 하이퍼 스탯 잔여 포인트

    @JsonProperty("hyper_stat_preset_3")
    private HyperStat hyperStatPreset3;  // 3번 프리셋 하이퍼 스탯 정보

    @JsonProperty("hyper_stat_preset_3_remain_point")
    private long hyperStatPreset3RemainPoint;  // 3번 프리셋 하이퍼 스탯 잔여 포인트

}