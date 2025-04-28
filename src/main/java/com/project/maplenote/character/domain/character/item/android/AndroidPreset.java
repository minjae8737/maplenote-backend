package com.project.maplenote.character.domain.character.item.android;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.item.CharacterFace;
import com.project.maplenote.character.domain.character.item.CharacterHair;
import com.project.maplenote.character.domain.character.item.CharacterSkin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AndroidPreset {
    @JsonProperty("android_name")
    private String androidName;

    @JsonProperty("android_nickname")
    private String androidNickname;

    @JsonProperty("android_icon")
    private String androidIcon;

    @JsonProperty("android_description")
    private String androidDescription;

    @JsonProperty("android_gender")
    private String androidGender;

    @JsonProperty("android_grade")
    private String androidGrade;

    @JsonProperty("android_skin")
    private CharacterSkin androidSkin;

    @JsonProperty("android_hair")
    private CharacterHair androidHair;

    @JsonProperty("android_face")
    private CharacterFace androidFace;

    @JsonProperty("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag;

    @JsonProperty("android_non_humanoid_flag")
    private String androidNonHumanoidFlag;

    @JsonProperty("android_shop_usable_flag")
    private String androidShopUsableFlag;
}