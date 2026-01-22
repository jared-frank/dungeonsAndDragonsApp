package com.dungeonsproject.characterdata.inventoryItems;

import java.util.UUID;

public class BundleItem extends InventoryItem{
    int currentQuantity;
    int maxQuantity;

    BundleItem(String name) {
        super.name = name;
        super.itemType = ItemType.BUNDLE;
        super.id = UUID.randomUUID();
    }

    BundleItem(String name, int currentQuantity, int maxQuantity) {
        super.name = name;
        super.itemType = ItemType.BUNDLE;
        super.id = UUID.randomUUID();
        this.currentQuantity = currentQuantity;
        this.maxQuantity = maxQuantity;
    }


    /* 
     * @returns number of bundle items that didn't fit in bundle
     */
    public int addToBundle(int addedAmount) {
        currentQuantity += addedAmount;
        if (currentQuantity > addedAmount) {
            int returnAmount = currentQuantity - maxQuantity;
            currentQuantity = maxQuantity;
            return returnAmount;
        } else {
            return 0;
        }
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}
