package com.dungeonsproject.characterdata;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

public class CharacterStorage {

    public boolean characterFileExists(){
        File characterFile = new File("character.json");
        return characterFile.exists();
    }

    public CharacterSheet loadStats() throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("character.json")) {
            CharacterSheet sheet = gson.fromJson(reader, CharacterSheet.class);
            return sheet;
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