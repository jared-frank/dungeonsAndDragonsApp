package com.dungeonsproject.uibuilder;

import static com.dungeonsproject.rules.SpellSlotEngine.FULL_CASTER_SLOTS;
import static com.dungeonsproject.rules.SpellSlotEngine.SLOT_TITLES;
import static com.dungeonsproject.rules.SpellSlotEngine.getMaxSpellLevel;

import java.util.HashMap;
import java.util.Map;

import com.dungeonsproject.characterdata.CharacterSheet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SpellSlotBuilder {

    public Map<Integer, Label> buildSpellSlotUI(HBox container, CharacterSheet sheet) {
        container.getChildren().clear();
        container.setAlignment(Pos.CENTER);

        Map<Integer, Label> remainingSpellSlotLabels = new HashMap<>();

        int maxSpellLevel = getMaxSpellLevel(sheet.getCharClass(), sheet.getLevel());

        for (int spellLevel = 1; spellLevel <= maxSpellLevel; spellLevel++) {
            int idx = spellLevel - 1;
            VBox col = createSpellSlotCol(spellLevel, sheet.getLevel(), 
                sheet.getRemainingSpellSlots()[idx], remainingSpellSlotLabels);
            container.getChildren().add(col);
        }

        return remainingSpellSlotLabels;
    }

    public ObservableList<String> getSpellSlotOptions(CharacterSheet sheet) {
        int maxSpellLevel = getMaxSpellLevel(sheet.getCharClass(), sheet.getLevel());
        ObservableList<String> spellOptions = FXCollections.observableArrayList();
        for (int level = 1; level <= maxSpellLevel; level++) {
            int idx = level - 1;
            spellOptions.add(SLOT_TITLES[idx] + " Level");
        }
        return spellOptions;
    }

    private VBox createSpellSlotCol(int spellLevel, 
            int charLevel, 
            int remainingSpellSlots,
            Map<Integer, Label> remainingSpellSlotLabels) {

        VBox col = new VBox(10);
        col.setAlignment(Pos.CENTER);

        int idx = spellLevel - 1;

        Label remainingSlotsLabel = new Label(remainingSpellSlots + " / " + FULL_CASTER_SLOTS.get(charLevel)[idx]);
        Label levelLabel = new Label(SLOT_TITLES[idx]);
        
        remainingSpellSlotLabels.put(spellLevel, remainingSlotsLabel);

        col.getChildren().add(remainingSlotsLabel);
        col.getChildren().add(levelLabel);
        
        return col;
    }
}


