package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedalShape {

    @JsonProperty("description")
    private String description;  // 외형 설정에 등록한 훈장 외형 정보

    @JsonProperty("medal_shape_name")
    private String medal_shape_name;  // 외형 설정에 등록한 훈장 장비 명

    @JsonProperty("medal_shape_icon")
    private String medal_shape_icon;  // 외형 설정에 등록한 훈장 아이콘

    @JsonProperty("medal_shape_description")
    private String medal_shape_description;  // 외형 설정에 등록한 훈장 설명

    @JsonProperty("medal_shape_changed_name")
    private String medal_shape_changed_name;  // 외형 설정에 등록한 훈장의 모루 적용 장비 명

    @JsonProperty("medal_shape_changed_icon")
    private String medal_shape_changed_icon;  // 외형 설정에 등록한 훈장의 모루 적용 아이콘

    @JsonProperty("medal_shape_changed_description")
    private String medal_shape_changed_description;  // 외형 설정에 등록한 훈장의 모루 적용 훈장 설명

}
