package com.project.maplenote.character.domain.character;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.item.SetEffect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 적용 세트 효과 정보
 */
@Getter
@Setter
@NoArgsConstructor
public class CharacterSetEffect {

    @JsonProperty("date")
    private String date;  // 조회 기준일

    @JsonProperty("SetEffect")
    private List<SetEffect> SetEffect;  // 세트 효과 명

}
