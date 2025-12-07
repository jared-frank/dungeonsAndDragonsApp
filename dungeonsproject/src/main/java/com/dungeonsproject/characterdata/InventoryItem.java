package com.dungeonsproject.characterdata;

import java.util.List;

public class InventoryItem {
    private String name;
    private int slotsUsed;
    private boolean isBundle;
    private int quantity; //only used if isBundle == true
    private int perSlotAmount; //unly used for bundles, 
    private boolean isPack; 
    private List<String> packItems; //only used if isPack == true;
    
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
    public boolean isBundle() {
        return isBundle;
    }
    public void setBundle(boolean isBundle) {
        this.isBundle = isBundle;
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
    public boolean isPack() {
        return isPack;
    }
    public void setPack(boolean isPack) {
        this.isPack = isPack;
    }
    public List<String> getPackItems() {
        return packItems;
    }
    public void setPackItems(List<String> packItems) {
        this.packItems = packItems;
    }
}
