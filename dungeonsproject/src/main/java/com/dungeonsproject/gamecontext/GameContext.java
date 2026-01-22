package com.dungeonsproject.gamecontext;

import com.dungeonsproject.characterdata.CharacterSheet;
import com.dungeonsproject.characterdata.Inventory;
import com.dungeonsproject.characterdata.inventoryItems.InventoryItem;

public class GameContext {

    private static GameContext instance;

    private CharacterSheet activeCharacter;
    private String activeCharacterDirectory;
    private Inventory inventory;

    private GameContext() {}

    public static GameContext getInstance() {
        if (instance == null) {
            instance = new GameContext();
        }
        return instance; 
    }

    public void setActiveCharacter(CharacterSheet sheet, String characterPath) {
        this.activeCharacter = sheet;
        this.activeCharacterDirectory = characterPath;
    }

    public CharacterSheet getCharacterSheet() {
        return activeCharacter;
    }

    public String getCharacterDirecotry() {
        return activeCharacterDirectory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addToInventory(InventoryItem item) {
        inventory.addToInventory(item);
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
