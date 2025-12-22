package com.dungeonsproject.characterdata;

import java.util.List;
import java.util.UUID;

public class InventoryItem {
    private String name;
    private int slotsUsed;
    private ItemType itemType;
    private int quantity; //only used if isBundle == true
    private int perSlotAmount; //unly used for bundles, 
    private List<String> packItems; //only used if isPack == true;
    private UUID id;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSlotsUsed() {
        return slotsUsed;
    }
    public void setSlotsUsed(int slotsUsed) {
        this.slotsUsed = slotsUsed;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getPerSlotAmount() {
        return perSlotAmount;
    }
    public void setPerSlotAmount(int perSlotAmount) {
        this.perSlotAmount = perSlotAmount;
    }
    public List<String> getPackItems() {
        return packItems;
    }
    public void setPackItems(List<String> packItems) {
        this.packItems = packItems;
    }
    public ItemType getItemType() {
        return itemType;
    }
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
}
