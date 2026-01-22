package com.dungeonsproject.characterdata.inventoryItems;

import java.util.UUID;

public abstract class InventoryItem {
    String name;
    int slotsUsed;
    ItemType itemType;
    UUID id = UUID.randomUUID();

    public String getName() {
        return name;
    }

    public int getSlotsUsed() {
        return slotsUsed;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlotsUsed(int slots) {
        this.slotsUsed = slots;
    }

    public void setItemType(ItemType type) {
        this.itemType = type;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public enum ItemType {
        HANDHELD,
        PACK,
        BUNDLE,
        ARMOR
    }
}
