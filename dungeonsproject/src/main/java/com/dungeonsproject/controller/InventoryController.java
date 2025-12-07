package com.dungeonsproject.controller;

import java.util.Map;

import com.dungeonsproject.characterdata.EquipmentSlot;
import com.dungeonsproject.characterdata.Inventory;
import com.dungeonsproject.characterdata.InventoryItem;
import com.dungeonsproject.characterdata.ItemType;
import com.dungeonsproject.gamecontext.GameContext;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InventoryController {

    @FXML 
    private VBox inventoryListContainer;

    @FXML 
    private ComboBox<ItemType> itemTypeCombo;

    @FXML 
    private VBox dynamicInputArea;

    @FXML 
    private VBox armorSlot;
    @FXML 
    private VBox mainHandSlot;
    @FXML 
    private VBox offHandSlot;

    private GameContext context = GameContext.getInstance();


    @FXML
    public void initialize() {
        populateInventory();

        itemTypeCombo.getItems().addAll(ItemType.values());

        itemTypeCombo.valueProperty().addListener((obs, oldVal, newVal) -> {
            buildDynamicInputs(newVal);
        });

        setupDropZone(armorSlot, EquipmentSlot.ARMOR);
        setupDropZone(mainHandSlot, EquipmentSlot.HAND);
        setupDropZone(offHandSlot, EquipmentSlot.HAND);
    }

    private void buildDynamicInputs(ItemType type) {
        dynamicInputArea.getChildren().clear();

        switch (type) {
            case HANDHELD -> buildRegularItemUI();
            case PACK -> buildPackUI();
            case BUNDLE -> buildBundleUI();
            case ARMOR -> buildEquipmentUI();
        }
    }

    private void buildRegularItemUI() {

        TextField nameField = new TextField();
        nameField.setPromptText("Item name");

        RadioButton oneSlot = new RadioButton("One Slot");
        RadioButton twoSlot = new RadioButton("Two Slots");

        ToggleGroup group = new ToggleGroup();
        oneSlot.setToggleGroup(group);
        twoSlot.setToggleGroup(group);

        dynamicInputArea.getChildren().addAll(nameField, oneSlot, twoSlot);
    }

    private void buildPackUI() {

        Label label = new Label("Paste item list:");

        TextArea area = new TextArea();
        area.setPrefHeight(200);

        dynamicInputArea.getChildren().addAll(label, area);
    }

    private void buildBundleUI() {
        TextField nameField = new TextField();
        nameField.setPromptText("Item Name");

        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");

        TextField perSlotField = new TextField();
        perSlotField.setPromptText("Per Slot Amount (only if new)");

        dynamicInputArea.getChildren().addAll(nameField, quantityField, perSlotField);
    }

    private void buildEquipmentUI() {

        TextField nameField = new TextField();
        nameField.setPromptText("Item name");

        dynamicInputArea.getChildren().addAll(nameField);
    }

    private void setupDropZone(VBox slot, EquipmentSlot type) {

        slot.setOnDragOver(event -> {
            if (event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        slot.setOnDragDropped(event -> {

            String itemName = event.getDragboard().getString();
            InventoryItem item = context.getInventory().getInventory().get(itemName);

            if (item != null) {

                Label label = new Label(itemName);

                slot.getChildren().clear();
                slot.getChildren().add(label);
            }

            event.setDropCompleted(true);
            event.consume();
        });
    }


    @FXML
    private void handleAddItem() {

    }

    private void populateInventory() {
        Map<String, InventoryItem> inventoryContents = context.getInventory().getInventory();

        for (Map.Entry<String, InventoryItem> entry : inventoryContents.entrySet()) {
            InventoryItem item = entry.getValue();
            HBox itemBox = new HBox();
            itemBox.getChildren().add(new Label(item.getName()));

            inventoryListContainer.getChildren().add(itemBox);
        }
    }

}

