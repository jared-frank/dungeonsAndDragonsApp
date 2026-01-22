package com.dungeonsproject.characterdata.jsonStorage;

import java.lang.reflect.Type;

import com.dungeonsproject.characterdata.inventoryItems.ArmorItem;
import com.dungeonsproject.characterdata.inventoryItems.BundleItem;
import com.dungeonsproject.characterdata.inventoryItems.HandheldItem;
import com.dungeonsproject.characterdata.inventoryItems.InventoryItem;
import com.dungeonsproject.characterdata.inventoryItems.PackItem;
import com.dungeonsproject.characterdata.inventoryItems.InventoryItem.ItemType;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class InventoryItemDeserializer implements JsonDeserializer<InventoryItem>{

    @Override
    public InventoryItem deserialize(
        JsonElement json,
        Type typeOfT,
        JsonDeserializationContext context
    ) throws JsonParseException {
        
        JsonObject obj = json.getAsJsonObject();
        
        ItemType type;
        try {
            type = ItemType.valueOf(obj.get("itemType").getAsString());
        } catch (IllegalArgumentException e) {
            throw new JsonParseException("Invalid ItemType: " + obj.get("type"), e);
        }

        return switch (type) {
            case ARMOR -> context.deserialize(obj, ArmorItem.class);
            case HANDHELD -> context.deserialize(obj, HandheldItem.class);
            case PACK -> context.deserialize(obj, PackItem.class);
            case BUNDLE -> context.deserialize(obj, BundleItem.class);
            default -> throw new JsonParseException("Unknown InventoryItem type: " + type);
        };
    }
}
