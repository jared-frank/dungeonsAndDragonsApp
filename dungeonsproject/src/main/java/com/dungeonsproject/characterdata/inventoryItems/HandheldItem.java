package com.dungeonsproject.characterdata.inventoryItems;

public class HandheldItem extends InventoryItem {

    HandheldItem(String name, int slotsUsed) {
        super.name = name;
        super.slotsUsed = slotsUsed;
        super.itemType = ItemType.HANDHELD;
    }
}

