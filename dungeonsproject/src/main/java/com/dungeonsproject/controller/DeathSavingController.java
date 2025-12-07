package com.dungeonsproject.controller;

import java.io.IOException;
import java.util.List;

import com.dungeonsproject.App;
import com.dungeonsproject.gamecontext.GameContext;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeathSavingController {

    private List<String> screenCounterDisplay = List.of("O O O", "X O O", "X X O", "X X X");
    
    private int saveCount;
    private int failCount;

    GameContext context = GameContext.getInstance();

    @FXML
    private Label saveThrowCount;
    @FXML
    private Label failThrowCount;
    @FXML
    private TextField healingInput;
    
    @FXML
    private void initialize(){
        failCount = 0;
        saveCount = 0;
    }
    
    @FXML
    private void onSave() throws IOException {
        saveCount += 1;
        if (saveCount >= 3) {
            context.getCharacterSheet().setCurrentHp(1);
            App.setRoot("gameplayTabs");
        } else {
            saveThrowCount.setText(screenCounterDisplay.get(saveCount));
        }
    }

    @FXML
    private void onFail() throws IOException {
        failCount += 1;
        if (failCount >= 3) {
            App.setRoot("ded");
        } else {
            failThrowCount.setText(screenCounterDisplay.get(failCount));
        }
    }

    @FXML
    private void onDoubleFail() throws IOException {
        failCount += 2;
        if (failCount >= 3) {
            App.setRoot("ded");
        } else {
            failThrowCount.setText(screenCounterDisplay.get(failCount));
        }
    }

    @FXML
    private void onDoubleSave() throws IOException {
        saveCount += 2;
        if (saveCount >= 3) {
            context.getCharacterSheet().setCurrentHp(1);
            App.setRoot("gameplayTabs");
        } else {
            saveThrowCount.setText(screenCounterDisplay.get(saveCount));
        }
    }

    @FXML
    private void onHeal() throws IOException {
        int currentHp = context.getCharacterSheet().getCurrentHp();
        int healingDamage = Integer.parseInt(healingInput.getText());

        currentHp += healingDamage;
        
        if (currentHp > context.getCharacterSheet().getMaxHp()) {
            currentHp = context.getCharacterSheet().getMaxHp();
        }

        context.getCharacterSheet().setCurrentHp(currentHp);
        App.setRoot("gameplayTabs");
    }
}
