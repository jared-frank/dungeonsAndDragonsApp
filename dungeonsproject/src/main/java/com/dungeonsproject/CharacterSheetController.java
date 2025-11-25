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

    private int maxHealth = 9;

    @FXML
    private void onDamageClick() throws IOException {
        int numbersOnly = Integer.parseInt(currentHpLabel.getText().replaceAll("[^0-9]", ""));
        int currentHealth = numbersOnly - Integer.parseInt(hpInput.getText());
        if (currentHealth + maxHealth <= 0) {
            App.setRoot("ded");
            return;
        }
        if (currentHealth < 0){
            currentHealth = 0;
        }
        currentHpLabel.setText("current Hp: " + currentHealth);
    }
    
    @FXML
    private void onHealClick() throws IOException {
        int numbersOnly = Integer.parseInt(currentHpLabel.getText().replaceAll("[^0-9]", ""));
        int currentHealth = numbersOnly + Integer.parseInt(hpInput.getText());
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
        currentHpLabel.setText("current Hp: " + currentHealth);
    }
    
}
