package com.dungeonsproject.controller;

import static com.dungeonsproject.rules.Ability.CHA;
import static com.dungeonsproject.rules.Ability.CON;
import static com.dungeonsproject.rules.Ability.DEX;
import static com.dungeonsproject.rules.Ability.ITL;
import static com.dungeonsproject.rules.Ability.STR;
import static com.dungeonsproject.rules.Ability.WIS;
import static com.dungeonsproject.rules.CharacterBonusEngine.computeSkillModifiers;

import static com.dungeonsproject.rules.SpellSlotEngine.FULL_CASTER_CLASSES;
import static com.dungeonsproject.rules.SpellSlotEngine.FULL_CASTER_SLOTS;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import com.dungeonsproject.App;
import com.dungeonsproject.characterdata.CharacterSheet;
import com.dungeonsproject.characterdata.Stats;
import com.dungeonsproject.rules.Skill;
import com.dungeonsproject.uibuilder.SpellSlotBuilder;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

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

    //Skills Display
    @FXML
    private Label acrobaticsSkill;
    @FXML
    private Label animalHandlingSkill;
    @FXML
    private Label arcanaSkill;
    @FXML
    private Label athleticsSkill;
    @FXML
    private Label deceptionSkill;
    @FXML
    private Label historySkill;
    @FXML
    private Label insightSkill;
    @FXML
    private Label intimidationSkill;
    @FXML
    private Label investigationSkill;
    @FXML
    private Label medicineSkill;
    @FXML
    private Label natureSkill;
    @FXML
    private Label perceptionSkill;
    @FXML
    private Label performanceSkill;
    @FXML
    private Label persuasionSkill;
    @FXML
    private Label religionSkill;
    @FXML
    private Label sleightOfHandSkill;
    @FXML
    private Label stealthSkill;
    @FXML
    private Label survivalSkill;

    //HP Tracker
    @FXML
    private Label currentHpLabel;
    @FXML
    private TextField hpInput;

    //Spell Tracker
    @FXML
    private ComboBox<String> spellSlotToUse;
    @FXML
    private HBox spellSlotContainer;
    private Map <Integer, Label> remainingspellSlotLabels;

    private SpellSlotBuilder spellSlotBuilder;

    private int maxHealth = App.getCharacterSheet().getMaxHp();

    private final String healthString = "Current HP: ";

    @FXML
    public void initialize() {
        CharacterSheet sheet = App.getCharacterSheet();

        spellSlotBuilder = new SpellSlotBuilder();

        nameLabel.setText(sheet.getName());
        levelLabel.setText("" + sheet.getLevel());
        classLabel.setText(sheet.getSubClass() + " " + sheet.getCharClass());
        raceLabel.setText(sheet.getSubRace() + " " + sheet.getRace());
        currentHpLabel.setText(healthString + sheet.getCurrentHp());

        Stats stats = sheet.getStats();
        showStatValues(stats);

        showSkillValues(sheet);

        spellSlotToUse.setItems(spellSlotBuilder.getSpellSlotOptions(sheet));

        remainingspellSlotLabels = spellSlotBuilder.buildSpellSlotUI(spellSlotContainer, App.getCharacterSheet());
    }

    @FXML
    private void onDamageClick() throws IOException {
        int numbersOnly = Integer.parseInt(currentHpLabel.getText().replaceAll("[^0-9]", ""));
        int currentHealth = numbersOnly - Integer.parseInt(hpInput.getText());
        if (currentHealth + maxHealth <= 0) {
            App.getCharacterSheet().setCurrentHp(0);
            App.setRoot("ded");
        } else if (currentHealth <= 0) {
            App.getCharacterSheet().setCurrentHp(0);
            App.setRoot("deathSaving");
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

    @FXML
    private void onUseSpell() throws IOException {
        String selectedSpellLevel = spellSlotToUse.getSelectionModel().getSelectedItem();
        switch (selectedSpellLevel) {
            case "First Level"  -> { subtractSpell(1); }
            case "Second Level" -> { subtractSpell(2); }
            case "Third Level"  -> { subtractSpell(3); }
            case "Fourth Level" -> { subtractSpell(4); }
            case "Fifth Level"  -> { subtractSpell(5); }
            case "Sixth Level"  -> { subtractSpell(6); }
            case "Seventh Level"-> { subtractSpell(7); }
            case "Eighth Level"  -> { subtractSpell(8); }
            case "Ninth Level"  -> { subtractSpell(9); }
        }
    }

    @FXML
    private void takeLongRest() throws IOException {
        String characterClass = App.getCharacterSheet().getCharClass();
        
        // Reset Spell Slots
        if (FULL_CASTER_CLASSES.contains(characterClass)) {
            int[] fullCasterSlots = FULL_CASTER_SLOTS.get(App.getCharacterSheet().getLevel());
            App.getCharacterSheet().setRemainingSpellSlots(Arrays.copyOf(fullCasterSlots, fullCasterSlots.length));

            for (Map.Entry<Integer, Label> entry : remainingspellSlotLabels.entrySet()) {
                int idx = entry.getKey() - 1;
                Label remainingSpells = entry.getValue();
                remainingSpells.setText( fullCasterSlots[idx] + " / " + fullCasterSlots[idx]);
            }
        }

        // Reset Health
        App.getCharacterSheet().setCurrentHp(maxHealth);
        currentHpLabel.setText(healthString + App.getCharacterSheet().getCurrentHp());
    }

    private void subtractSpell(int level) {
        int idx = level - 1;
        int[] currentSpells = App.getCharacterSheet().getRemainingSpellSlots();
        int currentSlotValue = currentSpells[idx];
        if (currentSlotValue > 0) {
            currentSpells[idx] = currentSlotValue - 1;
            App.getCharacterSheet().setRemainingSpellSlots(currentSpells);
        }

        remainingspellSlotLabels.get(level).setText(currentSpells[idx] + " / " + FULL_CASTER_SLOTS.get(App.getCharacterSheet().getLevel())[idx]);
    }

    private void showStatValues(Stats stats) {
        strMod.setText("(" + stats.getScore(STR) + ")");
        dexMod.setText("(" + stats.getScore(DEX) + ")");
        conMod.setText("(" + stats.getScore(CON) + ")");
        intMod.setText("(" + stats.getScore(ITL) + ")");
        wisMod.setText("(" + stats.getScore(WIS) + ")");
        chaMod.setText("(" + stats.getScore(CHA) + ")");

        strValue.setText(toModifierString(stats.getModifier(STR)));
        dexValue.setText(toModifierString(stats.getModifier(DEX)));
        conValue.setText(toModifierString(stats.getModifier(CON)));
        intValue.setText(toModifierString(stats.getModifier(ITL)));
        wisValue.setText(toModifierString(stats.getModifier(WIS)));
        chaValue.setText(toModifierString(stats.getModifier(CHA)));
    }

    private void showSkillValues(CharacterSheet sheet) {
        Map<String, Integer> skillMap = computeSkillModifiers(sheet);

        acrobaticsSkill.setText(toModifierString(skillMap.get(Skill.ACROBATICS.name)));
        animalHandlingSkill.setText(toModifierString(skillMap.get(Skill.ANIMAL_HANDLING.name)));
        arcanaSkill.setText(toModifierString(skillMap.get(Skill.ARCANA.name)));
        athleticsSkill.setText(toModifierString(skillMap.get(Skill.ATHLETICS.name)));
        deceptionSkill.setText(toModifierString(skillMap.get(Skill.DECEPTION.name)));
        historySkill.setText(toModifierString(skillMap.get(Skill.HISTORY.name)));
        insightSkill.setText(toModifierString(skillMap.get(Skill.INSIGHT.name)));
        intimidationSkill.setText(toModifierString(skillMap.get(Skill.INTIMIDATION.name)));
        investigationSkill.setText(toModifierString(skillMap.get(Skill.INVESTIGATION.name)));
        medicineSkill.setText(toModifierString(skillMap.get(Skill.MEDICINE.name)));
        natureSkill.setText(toModifierString(skillMap.get(Skill.NATURE.name)));
        perceptionSkill.setText(toModifierString(skillMap.get(Skill.PERCEPTION.name)));
        performanceSkill.setText(toModifierString(skillMap.get(Skill.PERFORMANCE.name)));
        persuasionSkill.setText(toModifierString(skillMap.get(Skill.PERSUASION.name)));
        religionSkill.setText(toModifierString(skillMap.get(Skill.RELIGION.name)));
        sleightOfHandSkill.setText(toModifierString(skillMap.get(Skill.SLEIGHT_OF_HAND.name)));
        stealthSkill.setText(toModifierString(skillMap.get(Skill.STEALTH.name)));
        survivalSkill.setText(toModifierString(skillMap.get(Skill.SURVIVAL.name)));
    }

    private String toModifierString(int modifier) {
        if (modifier > 0) {
            return "+" + modifier;
        } else {
            return "" + modifier;
        }
    }
    
}
