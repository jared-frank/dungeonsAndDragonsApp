package com.dungeonsproject.characterdata.jsonStorage;

import java.util.List;

import com.dungeonsproject.characterdata.inventoryItems.InventoryItem;

public class InventoryStorageModel {
    List<InventoryItem> items;

    public List<InventoryItem> getItems() {
        return items;
    }

    public void setItems(List<InventoryItem> items) {
        this.items = items;
    }
}
