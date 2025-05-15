package com.project.maplenote.character.domain.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.item.*;
import com.project.maplenote.character.domain.character.item.android.AndroidCashItem;
import com.project.maplenote.character.domain.character.item.android.AndroidPreset;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CharacterAndroidEquipment {

    @JsonProperty("date")
    private String date; // 조회 기준일 (KST)

    @JsonProperty("android_name")
    private String androidName; // 안드로이드 명

    @JsonProperty("android_nickname")
    private String androidNickname; // 안드로이드 닉네임

    @JsonProperty("android_icon")
    private String androidIcon; // 안드로이드 아이콘

    @JsonProperty("android_description")
    private String androidDescription; // 안드로이드 아이템 설명

    @JsonProperty("android_hair")
    private CharacterHair androidHair; // 안드로이드 헤어 정보

    @JsonProperty("android_face")
    private CharacterFace androidFace; // 안드로이드 성형 정보

    @JsonProperty("android_skin")
    private CharacterSkin androidSkin; // 안드로이드 피부 정보

    @JsonProperty("android_cash_item_equipment")
    private List<AndroidCashItem> androidCashItemEquipment; // 안드로이드 캐시 아이템 장착 정보

    @JsonProperty("android_ear_sensor_clip_flag")
    private String androidEarSensorClipFlag; // 이어센서 클립 적용 여부

    @JsonProperty("android_gender")
    private String androidGender; // 안드로이드 성별

    @JsonProperty("android_grade")
    private String androidGrade; // 안드로이드 등급

    @JsonProperty("android_non_humanoid_flag")
    private String androidNonHumanoidFlag; // 비인간형 여부

    @JsonProperty("android_shop_usable_flag")
    private String androidShopUsableFlag; // 잡화상점 기능 이용 가능 여부

    @JsonProperty("preset_no")
    private Long presetNo; // 적용 중인 장비 프리셋 번호

    @JsonProperty("android_preset_1")
    private AndroidPreset androidPreset1; // 1번 프리셋

    @JsonProperty("android_preset_2")
    private AndroidPreset androidPreset2; // 2번 프리셋

    @JsonProperty("android_preset_3")
    private AndroidPreset androidPreset3; // 3번 프리셋

}

