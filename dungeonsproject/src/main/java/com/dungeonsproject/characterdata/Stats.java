package com.dungeonsproject.characterdata;

import com.dungeonsproject.constants.Ability;

public class Stats {
    private int str;
    private int dex;
    private int con;
    private int itl;
    private int wis;
    private int cha;
    
    public int getModifier(Ability ability) {
        return switch(ability) {
            case STR -> (str - 10) / 2;
            case DEX -> (dex - 10) / 2;
            case CON -> (con - 10) / 2;
            case ITL -> (itl - 10) / 2;
            case WIS -> (wis - 10) / 2;
            case CHA -> (cha - 10) / 2;
        };
    }

    public int getStr() {
        return str;
    }
    public void setStr(int str) {
        this.str = str;
    }
    public int getDex() {
        return dex;
    }
    public void setDex(int dex) {
        this.dex = dex;
    }
    public int getCon() {
        return con;
    }
    public void setCon(int con) {
        this.con = con;
    }
    public int getItl() {
        return itl;
    }
    public void setItl(int itl) {
        this.itl = itl;
    }
    public int getWis() {
        return wis;
    }
    public void setWis(int wis) {
        this.wis = wis;
    }
    public int getCha() {
        return cha;
    }
    public void setCha(int cha) {
        this.cha = cha;
    }
}
