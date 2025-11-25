package com.dungeonsproject;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CharacterSheetController {

    @FXML
    private Label currentHpLabel;

    @FXML
    private TextField hpInput;

    private int maxHealth = App.getCharacterSheet().getMaxHp();

    private final String healthString = "Current HP: ";

    @FXML
    public void initialize() {
        currentHpLabel.setText(healthString + App.getCharacterSheet().getCurrentHp());
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
    
}
