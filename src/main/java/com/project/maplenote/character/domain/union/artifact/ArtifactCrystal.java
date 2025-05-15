package com.project.maplenote.character.domain.union.artifact;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArtifactCrystal {

    @JsonProperty("name")
    private String name; // 아티팩트 크리스탈 명

    @JsonProperty("validity_flag")
    private String validityFlag; // 능력치 유효 여부 (0: 유효, 1: 유효하지 않음)

    @JsonProperty("date_expire")
    private String dateExpire; // 능력치 유효 기간 (expired: 만료, null: 무제한)

    @JsonProperty("level")
    private Long level; // 아티팩트 크리스탈 등급

    @JsonProperty("crystal_option_name_1")
    private String crystalOptionName1; // 첫 번째 옵션 명

    @JsonProperty("crystal_option_name_2")
    private String crystalOptionName2; // 두 번째 옵션 명

    @JsonProperty("crystal_option_name_3")
    private String crystalOptionName3; // 세 번째 옵션 명

}
