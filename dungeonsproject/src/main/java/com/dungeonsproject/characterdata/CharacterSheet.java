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
    private List<String> skills;
    private String background;
    private String subClass;
    private HitDice hitDice;

    public static class Stats {
        private int str;
        private int dex;
        private int con;
        private int itl;
        private int wis;
        private int cha;
        
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
    
    public static class HitDice {
        private int quantity;
        private int type;
        private int bonus;

        public int getQuantity() {
            return quantity;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        public int getType() {
            return type;
        }
        public void setType(int type) {
            this.type = type;
        }
        public int getBonus() {
            return bonus;
        }
        public void setBonus(int bonus) {
            this.bonus = bonus;
        }
    }

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

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
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

    public HitDice getHitDice() {
        return hitDice;
    }

    public void setHitDice(HitDice hitDice) {
        this.hitDice = hitDice;
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
}
