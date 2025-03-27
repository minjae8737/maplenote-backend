package com.project.maplenote.character.domain.character.item.android;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.CharacterAndroidEquipment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AndroidCashItem {
    @JsonProperty("cash_item_equipment_part")
    private String cashItemEquipmentPart;

    @JsonProperty("cash_item_equipment_slot")
    private String cashItemEquipmentSlot;

    @JsonProperty("cash_item_name")
    private String cashItemName;

    @JsonProperty("cash_item_icon")
    private String cashItemIcon;

    @JsonProperty("cash_item_description")
    private String cashItemDescription;

    @JsonProperty("cash_item_option")
    private List<CharacterAndroidEquipment.CashItemOption> cashItemOption;

    @JsonProperty("date_expire")
    private String dateExpire;

    @JsonProperty("date_option_expire")
    private String dateOptionExpire;

    @JsonProperty("cash_item_label")
    private String cashItemLabel;

    @JsonProperty("cash_item_coloring_prism")
    private CharacterAndroidEquipment.CashItemColoringPrism cashItemColoringPrism;

    @JsonProperty("android_item_gender")
    private String androidItemGender;
}
