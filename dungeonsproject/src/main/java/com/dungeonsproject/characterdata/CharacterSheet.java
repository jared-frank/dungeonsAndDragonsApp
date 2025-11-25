package com.dungeonsproject.characterdata;

public class CharacterSheet {
    private int currentHp;
    private int maxHp;
    
    private int strStat;
    private int dexStat;
    private int conStat;
    private int intStat;
    private int wisStat;
    private int chaStat;

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
    public int getStrStat() {
        return strStat;
    }
    public void setStrStat(int strStat) {
        this.strStat = strStat;
    }
    public int getDexStat() {
        return dexStat;
    }
    public void setDexStat(int dexStat) {
        this.dexStat = dexStat;
    }
    public int getConStat() {
        return conStat;
    }
    public void setConStat(int conStat) {
        this.conStat = conStat;
    }
    public int getIntStat() {
        return intStat;
    }
    public void setIntStat(int intStat) {
        this.intStat = intStat;
    }
    public int getWisStat() {
        return wisStat;
    }
    public void setWisStat(int wisStat) {
        this.wisStat = wisStat;
    }
    public int getChaStat() {
        return chaStat;
    }
    public void setChaStat(int chaStat) {
        this.chaStat = chaStat;
    }
}
