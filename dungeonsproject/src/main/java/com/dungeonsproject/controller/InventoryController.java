package com.dungeonsproject.controller;

import java.util.Map;
import java.util.UUID;

import com.dungeonsproject.characterdata.EquipmentSlot;
import com.dungeonsproject.characterdata.InventoryItem;
import com.dungeonsproject.characterdata.ItemType;
import com.dungeonsproject.gamecontext.GameContext;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
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

        setupInventoryReturnZone();
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
                Dragboard db = event.getDragboard();

                if (db.hasString()) {
                    InventoryItem item = context.getInventory()
                            .getInventory()
                            .get(UUID.fromString(db.getString()));

                    if (item != null && isValidForSlot(item, type)) {
                        event.acceptTransferModes(TransferMode.MOVE);
                    }
                }
                event.consume();
            });


        slot.setOnDragDropped(event -> {

            String id = event.getDragboard().getString();
            InventoryItem newItem = context.getInventory().getInventory().get(UUID.fromString(id));

            if (newItem != null && isValidForSlot(newItem, type)) {

                String oldItemId = getItemIdFromSlot(slot);

                if (oldItemId != null && !oldItemId.equals(id)) {
                    InventoryItem oldItem = context.getInventory()
                            .getInventory()
                            .get(UUID.fromString(oldItemId));

                    if (oldItem != null && !isAlreadyInInventory(oldItemId)) {
                        inventoryListContainer.getChildren().add(buildInventoryItemNode(oldItem));
                    }
                }

                slot.getChildren().clear();
                Label label = new Label(newItem.getName());
                label.setUserData(newItem.getId().toString());
                slot.getChildren().add(label);

                removeItemFromInventoryUI(id);

                enableUnequipDrag(label, newItem);
            }

            event.setDropCompleted(true);
            event.consume();
        });
    }


    @FXML
    private void handleAddItem() {

    }

    private void populateInventory() {
        Map<UUID, InventoryItem> inventoryContents = context.getInventory().getInventory();

        for (Map.Entry<UUID, InventoryItem> entry : inventoryContents.entrySet()) {
            InventoryItem item = entry.getValue();
            inventoryListContainer.getChildren().add(buildInventoryItemNode(item));
        }
    }

    private Node buildInventoryItemNode(InventoryItem item) {

        Label name = new Label(item.getName());
        name.setUserData(item.getId().toString());


        HBox wrapper = new HBox(name);
        wrapper.setStyle("-fx-border-color: black; -fx-padding: 10;");

        wrapper.setOnDragDetected(e -> {
            Dragboard db = wrapper.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(item.getId().toString());
            db.setContent(content);
            e.consume();
        });

        wrapper.setUserData(item.getId().toString());

        return wrapper;
    }

    private boolean isValidForSlot(InventoryItem item, EquipmentSlot slot) {
        return switch (slot) {
            case ARMOR -> item.getItemType() == ItemType.ARMOR;
            case HAND -> item.getItemType() == ItemType.HANDHELD;
        };
    }   


    private void removeItemFromInventoryUI(String id) {

        Node toRemove = null;

        for (Node node : inventoryListContainer.getChildren()) {
            if (node.getUserData() != null &&
                node.getUserData().toString().equals(id)) {

                toRemove = node;
                break;
            }
        }

        if (toRemove != null) {
            inventoryListContainer.getChildren().remove(toRemove);
        }
    }

   private void enableUnequipDrag(Label label, InventoryItem item) {

        label.setOnDragDetected(e -> {
            Dragboard db = label.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();

            content.putString(item.getId().toString());

            db.setContent(content);
            e.consume();
        });
    }


    private void setupInventoryReturnZone() {

        inventoryListContainer.setOnDragOver(event -> {
            if (event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        inventoryListContainer.setOnDragDropped(event -> {
            String itemId = event.getDragboard().getString();
            InventoryItem item = context.getInventory().getInventory().get(UUID.fromString(itemId));

            if (item != null) {

                if (isAlreadyInInventory(item.getId().toString())) {
                    event.setDropCompleted(false);
                    return;
                }

                inventoryListContainer.getChildren().add(buildInventoryItemNode(item));

                // Remove from any equipped slot
                clearSlotIfContains(armorSlot, item.getId().toString(), "Armmor");
                clearSlotIfContains(mainHandSlot,  item.getId().toString(), "Main Hand");
                clearSlotIfContains(offHandSlot, item.getId().toString(), "Off Hand");

                // context.getEquipment().unequip(item); // optional but clean
            }

            event.setDropCompleted(true);
            event.consume();
        });
    }

    private boolean isAlreadyInInventory(String id) {
        for (Node node : inventoryListContainer.getChildren()) {
            if (node instanceof HBox hbox && hbox.getUserData() != null) {
                if (hbox.getUserData().toString().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }


    private void clearSlotIfContains(VBox slot, String id, String slotName) {
        if (slot.getChildren().isEmpty()) return;

        Node node = slot.getChildren().get(0);

        if (!(node instanceof Label)) return;

        Label label = (Label) node;
        Object ud = label.getUserData();

        if (ud != null && ud.toString().equals(id)) {
            slot.getChildren().clear();
            // Restore the placeholder label (no userData)
            slot.getChildren().add(new Label(slotName));
        }
    }

    private String getItemIdFromSlot(VBox slot) {
        if (!slot.getChildren().isEmpty() &&
            slot.getChildren().get(0) instanceof Label label &&
            label.getUserData() != null) {
            return label.getUserData().toString();
        }
        return null;
    }

}

