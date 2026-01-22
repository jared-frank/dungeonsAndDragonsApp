package com.dungeonsproject.controller;

import java.io.IOException;

import com.dungeonsproject.App;
import com.dungeonsproject.characterdata.CharacterSheet;
import com.dungeonsproject.characterdata.CharacterSummary;
import com.dungeonsproject.characterdata.Inventory;
import com.dungeonsproject.characterdata.jsonStorage.CharacterStorage;
import com.dungeonsproject.gamecontext.GameContext;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CharacterSelectController {

    @FXML
    private ListView<CharacterSummary> characterListView;

    private ObservableList<CharacterSummary> characters = FXCollections.observableArrayList();

    private CharacterStorage characterStorage = new CharacterStorage();

    GameContext context = GameContext.getInstance();

    @FXML
    public void initialize() throws IOException {
        characters.clear();
        characters.setAll(characterStorage.loadCharacterSummaries());
        characterListView.setItems(characters);
    }

    @FXML
    private void handleLoadCharacter() throws IOException {
        CharacterSummary selected = characterListView.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        System.out.println("Loading character: " + selected.getName());

        initializeCharacterSheet(selected.getFilePath());
        App.setRoot("gameplayTabs");
    }

    @FXML
    private void handleNewCharacter() {
        // Later: open CreateCharacter.fxml
    }

    @FXML
    private void handleDeleteCharacter() {
        // Later: delete directory
    }

     public void initializeCharacterSheet(String selectedFilePath) throws IOException {
        CharacterSheet loadedSheet = characterStorage.loadStats(selectedFilePath);
        context.setActiveCharacter(loadedSheet, null);

        Inventory inventory = characterStorage.loadInventory(selectedFilePath);
        context.setInventory(inventory);
    }
}
