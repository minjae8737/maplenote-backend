package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 칭호 정보
 */
@Getter
@Setter
public class Title {

    @JsonProperty("description")
    private String description;  // 칭호 정보

    @JsonProperty("title_name")
    private String title_name;  // 칭호 장비 명

    @JsonProperty("title_icon")
    private String title_icon;  // 칭호 아이콘

    @JsonProperty("title_description")
    private String title_description;  // 칭호 설명

    @JsonProperty("date_expire")
    private String date_expire;  // 칭호 유효 기간 (expired: 만료, null: 무제한)

    @JsonProperty("date_option_expire")
    private String date_option_expire;  // 칭호 옵션 유효 기간 (expired: 만료, null: 무제한)

    @JsonProperty("title_shape_name")
    private String title_shape_name;  // 외형 설정에 등록한 칭호 장비 명

    @JsonProperty("title_shape_icon")
    private String title_shape_icon;  // 외형 설정에 등록한 칭호 아이콘

    @JsonProperty("title_shape_description")
    private String title_shape_description;  // 외형 설정에 등록한 칭호 설명

}
