package com.dungeonsproject.characterdata.inventoryItems;

import java.util.UUID;

public class ArmorItem extends InventoryItem {

    ArmorCategory category;
    int armorClass; 
    boolean stealthDisadvantage;
    int strengthScore;
    
    ArmorItem(String name) {
        super.name = name;
        super.itemType = ItemType.ARMOR;
        super.id = UUID.randomUUID();
    }

    ArmorItem(String name, ArmorCategory category, 
        int armorClass, boolean stealthDisadvantage, int strengthScore) {
            super.name = name;
            super.itemType = ItemType.ARMOR;
            this.category = category;
            this.armorClass = armorClass;
            this.stealthDisadvantage = stealthDisadvantage;
            this.strengthScore = strengthScore;
            super.id = UUID.randomUUID();
        }

    public int getArmorClass(int dexMod) {
        switch (category) {
            case LIGHT -> {
                return armorClass + dexMod;
            }
            case MEDIUM -> {
                return armorClass + Math.min(2, dexMod);
            }
            case HEAVY -> {
                return armorClass;
            }
            default -> {
                return -1;
            }
        }
    }

    public enum ArmorCategory {
        LIGHT,
        MEDIUM,
        HEAVY
    }
}


