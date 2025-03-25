package com.project.maplenote.character.domain.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CashItemEquipment {

    @JsonProperty("cash_item_equipment_part")
    private String cashItemEquipmentPart; // 캐시 장비 부위 명

    @JsonProperty("cash_item_equipment_slot")
    private String cashItemEquipmentSlot; // 캐시 장비 슬롯 위치

    @JsonProperty("cash_item_name")
    private String cashItemName; // 캐시 장비 명

    @JsonProperty("cash_item_icon")
    private String cashItemIcon; // 캐시 장비 아이콘

    @JsonProperty("cash_item_description")
    private String cashItemDescription; // 캐시 장비 설명

    @JsonProperty("cash_item_option")
    private List<CashItemOption> cashItemOption; // 캐시 장비 옵션

    @JsonProperty("date_expire")
    private String dateExpire; // 캐시 장비 유효 기간 (expired: 만료, null: 무제한)

    @JsonProperty("date_option_expire")
    private String dateOptionExpire; // 캐시 장비 옵션 유효 기간 (expired: 만료, null: 무제한)

    @JsonProperty("cash_item_label")
    private String cashItemLabel; // 캐시 장비 라벨 정보

    @JsonProperty("cash_item_coloring_prism")
    private CashItemColoringPrism cashItemColoringPrism; // 캐시 장비 컬러링프리즘 정보

    @JsonProperty("item_gender")
    private String itemGender; // 아이템 장착 가능 성별

    @JsonProperty("skill")
    private List<String> skill; // 스킬명 목록
}
