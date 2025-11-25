package com.dungeonsproject;

import java.io.IOException;

import com.dungeonsproject.characterdata.CharacterSheet;
import com.dungeonsproject.characterdata.CharacterSheet.Stats;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CharacterSheetController {

    //Labels for Character Info
    @FXML
    private Label nameLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label classLabel;
    @FXML
    private Label raceLabel;

    //Labels for Stats
    @FXML
    private Label strValue;
    @FXML
    private Label strMod;
    @FXML
    private Label dexValue;
    @FXML
    private Label dexMod;
    @FXML
    private Label conValue;
    @FXML
    private Label conMod;
    @FXML
    private Label intValue;
    @FXML
    private Label intMod;
    @FXML
    private Label wisValue;
    @FXML
    private Label wisMod;
    @FXML
    private Label chaValue;
    @FXML
    private Label chaMod;

    //HP Tracker
    @FXML
    private Label currentHpLabel;
    @FXML
    private TextField hpInput;

    private int maxHealth = App.getCharacterSheet().getMaxHp();

    private final String healthString = "Current HP: ";

    @FXML
    public void initialize() {
        CharacterSheet sheet = App.getCharacterSheet();

        nameLabel.setText(sheet.getName());
        levelLabel.setText("" + sheet.getLevel());
        classLabel.setText(sheet.getSubClass() + " " + sheet.getCharClass());
        raceLabel.setText(sheet.getSubRace() + " " + sheet.getRace());
        currentHpLabel.setText(healthString + sheet.getCurrentHp());

        Stats stats = sheet.getStats();

        strMod.setText("(" + stats.getStr() + ")");
        dexMod.setText("(" + stats.getDex() + ")");
        conMod.setText("(" + stats.getCon() + ")");
        intMod.setText("(" + stats.getItl() + ")");
        wisMod.setText("(" + stats.getWis() + ")");
        chaMod.setText("(" + stats.getCha() + ")");

        strValue.setText(calculateModifier(stats.getStr()));
        dexValue.setText(calculateModifier(stats.getDex()));
        conValue.setText(calculateModifier(stats.getCon()));
        intValue.setText(calculateModifier(stats.getItl()));
        wisValue.setText(calculateModifier(stats.getWis()));
        chaValue.setText(calculateModifier(stats.getCha()));
    }

    @FXML
    private void onDamageClick() throws IOException {
        int numbersOnly = Integer.parseInt(currentHpLabel.getText().replaceAll("[^0-9]", ""));
        int currentHealth = numbersOnly - Integer.parseInt(hpInput.getText());
        if (currentHealth + maxHealth <= 0) {
            App.getCharacterSheet().setCurrentHp(0);
            App.setRoot("ded");
        } else if (currentHealth < 0) {
            App.getCharacterSheet().setCurrentHp(0);
            currentHpLabel.setText(healthString + "0");
        } else {
            App.getCharacterSheet().setCurrentHp(currentHealth);
            currentHpLabel.setText(healthString + currentHealth);
        }
    }
    
    @FXML
    private void onHealClick() throws IOException {
        int numbersOnly = Integer.parseInt(currentHpLabel.getText().replaceAll("[^0-9]", ""));
        int currentHealth = numbersOnly + Integer.parseInt(hpInput.getText());
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
        currentHpLabel.setText(healthString + currentHealth);
    }

    private String calculateModifier(int value) {
        int calculatedMod = (value - 10) / 2;
        if (calculatedMod > 0) {
            return "+" + calculatedMod;
        } else {
            return "" + calculatedMod;
        }
    }
    
}
