package com.dungeonsproject.characterdata;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.dungeonsproject.characterdata.inventoryItems.InventoryItem;

public class Inventory {
    private Map<UUID, InventoryItem> items;
    
    Inventory(Map<UUID,InventoryItem> items) {
        this.items = items;
    }

    public Inventory() {
        this.items = new HashMap<>();
    }

    public Map<UUID, InventoryItem> getInventory() {
        return items;
    }

    public void addToInventory(InventoryItem item) {
        items.put(item.getId() ,item);
    }

    public void removeFromInventory(InventoryItem item) {
        items.remove(item.getId());
    }
}
