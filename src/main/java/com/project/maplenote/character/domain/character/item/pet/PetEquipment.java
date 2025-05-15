package com.project.maplenote.character.domain.character.item.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.maplenote.character.domain.character.item.ItemOption;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PetEquipment {
    @JsonProperty("item_name")
    private String itemName; // 아이템 명

    @JsonProperty("item_icon")
    private String itemIcon; // 아이템 아이콘

    @JsonProperty("item_description")
    private String itemDescription; // 아이템 설명

    @JsonProperty("item_option")
    private List<ItemOption> itemOptions; // 아이템 표기상 옵션

    @JsonProperty("scroll_upgrade")
    private Long scrollUpgrade; // 업그레이드 횟수

    @JsonProperty("scroll_upgradable")
    private Long scrollUpgradable; // 업그레이드 가능 횟수

    @JsonProperty("item_shape")
    private String itemShape; // 아이템 외형

    @JsonProperty("item_shape_icon")
    private String itemShapeIcon; // 아이템 외형 아이콘

}