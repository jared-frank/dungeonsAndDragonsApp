package com.dungeonsproject.characterdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;

public class CharacterStorage {

    private static final String CHARACTER_ROOT = "characters";

    public boolean characterFileExists(){
        File root = new File(CHARACTER_ROOT);
        File[] characterFolders = root.listFiles(File::isDirectory);
        return characterFolders != null;
    }

    public CharacterSheet loadStats(String characterPath) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(characterPath + "/character.json")) {
            CharacterSheet sheet = gson.fromJson(reader, CharacterSheet.class);
            return sheet;
        }
    }

    public List<CharacterSummary> loadCharacterSummaries() throws IOException {
        List<CharacterSummary> summaries = new ArrayList<>();

        File root = new File(CHARACTER_ROOT);
        if (!root.exists()) {
            root.mkdirs();
            return null;
        }

        File[] characterFolders = root.listFiles(File::isDirectory);
        if (characterFolders == null) {
            return null;
        }

        for (File folder : characterFolders) {
            Gson gson = new Gson();

            try (FileReader reader = new FileReader(folder.getPath() + "/character.json")) {
                CharacterSummary summary = gson.fromJson(reader, CharacterSummary.class);
                summary.setFilePath(folder.getPath());
                summaries.add(summary);
            }
        }
        return summaries;
    }

    public Inventory loadInventory(String characterPath) throws IOException{
        Gson gson = new Gson();
        
        try (FileReader reader = new FileReader(characterPath + "/inventory.json")) {
            InventoryStorageModel inventoryModel = gson.fromJson(reader, InventoryStorageModel.class);

            Inventory inventory = new Inventory();

            for (InventoryItem item : inventoryModel.getItems()) {
                UUID itemId = UUID.randomUUID();
                item.setId(itemId);
                inventory.addToInventory(item);
            }

            return inventory;
        }
    } 
    

    public void saveStats(CharacterSheet sheet) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(sheet);

        try (FileWriter writer = new FileWriter("character.json")) {
            writer.write(json);
        }
    }
    
}