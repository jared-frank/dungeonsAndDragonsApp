package com.dungeonsproject.characterdata;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, InventoryItem> items;
    
    Inventory(Map<String,InventoryItem> items) {
        this.items = items;
    }

    Inventory() {
        this.items = new HashMap<>();
    }

    public Map<String, InventoryItem> getInventory() {
        return items;
    }

    public void addToInventory(InventoryItem item) {
        items.put(item.getName() ,item);
    }

    public void removeFromInventory(InventoryItem item) {
        items.remove(item.getName());
    }
}
