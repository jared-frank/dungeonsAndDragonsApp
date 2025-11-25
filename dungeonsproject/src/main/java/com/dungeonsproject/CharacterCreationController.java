package com.dungeonsproject;

import java.io.IOException;

import com.dungeonsproject.characterdata.CharacterSheet;
import com.dungeonsproject.characterdata.CharacterStorage;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CharacterCreationController {

    private static CharacterStorage characterStorage = new CharacterStorage();

    @FXML
    private TextField maxHpInput;

    @FXML
    private void onCreateCharacter() throws IOException {
        CharacterSheet sheet = new CharacterSheet();
        int health = Integer.parseInt(maxHpInput.getText().replaceAll("[^0-9]", ""));

        sheet.setMaxHp(health);
        sheet.setCurrentHp(health); //start character with max HP

        App.setCharacterSheet(sheet);
        characterStorage.saveStats(sheet);

        App.setRoot("characterSheet");
    }
}
