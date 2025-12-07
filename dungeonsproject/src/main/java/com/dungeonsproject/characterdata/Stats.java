package com.dungeonsproject.characterdata;

import com.dungeonsproject.rules.Ability;

public class Stats {
    private int str;
    private int dex;
    private int con;
    private int itl;
    private int wis;
    private int cha;
    
    public int getModifier(Ability ability) {
        return switch(ability) {
            case STR -> Math.floorDiv((str - 10), 2);
            case DEX -> Math.floorDiv((dex - 10), 2);
            case CON -> Math.floorDiv((con - 10), 2);
            case ITL -> Math.floorDiv((itl - 10), 2);
            case WIS -> Math.floorDiv((wis - 10), 2);
            case CHA -> Math.floorDiv((cha - 10), 2);
        };
    }

    public int getScore(Ability ability) {
        return switch(ability) {
            case STR -> str;
            case DEX -> dex;
            case CON -> con;
            case ITL -> itl;
            case WIS -> wis;
            case CHA -> cha;
        };
    }

   public void setScore(Ability ability, int score) {
        switch(ability) {
            case STR -> this.str = score;
            case DEX -> this.dex = score;
            case CON -> this.con = score;
            case ITL -> this.itl = score;
            case WIS -> this.wis = score;
            case CHA -> this.cha = score;
        }
   }
}
