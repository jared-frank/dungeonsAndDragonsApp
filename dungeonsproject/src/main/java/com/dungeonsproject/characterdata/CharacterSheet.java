package com.dungeonsproject.characterdata;

import java.util.List;

public class CharacterSheet {
    private String name;
    private int level;
    private String charClass;
    private String race;
    private String subRace;
    private int currentHp;
    private int maxHp;
    private int speed;
    private Stats stats;
    private List<String> proficiences;
    private List<String> expertise;
    private String background;
    private String subClass;
    private int[] remainingSpellSlots;

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getSubClass() {
        return subClass;
    }

    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }

    public String getSubRace() {
        return subRace;
    }

    public void setSubRace(String subRace) {
        this.subRace = subRace;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<String> getProficiences() {
        return proficiences;
    }

    public void setProficiences(List<String> proficiences) {
        this.proficiences = proficiences;
    }

    public List<String> getExpertise() {
        return expertise;
    }

    public void setExpertise(List<String> expertise) {
        this.expertise = expertise;
    }

    public int[] getRemainingSpellSlots() {
        return remainingSpellSlots;
    }

    public void setRemainingSpellSlots(int[] remainingSpellSlots) {
        this.remainingSpellSlots = remainingSpellSlots;
    }
    
}
