package com.dungeonsproject.controller;

import java.io.IOException;

import com.dungeonsproject.App;
import com.dungeonsproject.characterdata.CharacterSheet;
import com.dungeonsproject.characterdata.jsonStorage.CharacterStorage;
import com.dungeonsproject.gamecontext.GameContext;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CharacterCreationController {

    private static CharacterStorage characterStorage = new CharacterStorage();

    GameContext context = GameContext.getInstance();

    @FXML
    private TextField maxHpInput;

    @FXML
    private void onCreateCharacter() throws IOException {
        CharacterSheet sheet = new CharacterSheet();
        int health = Integer.parseInt(maxHpInput.getText().replaceAll("[^0-9]", ""));

        sheet.setMaxHp(health);
        sheet.setCurrentHp(health); //start character with max HP

        context.setActiveCharacter(sheet, null);
        characterStorage.saveStats(sheet);

        App.setRoot("gameplayTabs");
    }
}
