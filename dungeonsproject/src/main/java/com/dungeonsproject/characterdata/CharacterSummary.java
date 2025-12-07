package com.dungeonsproject.characterdata;

public class CharacterSummary {
    private String name;
    private String charClass;
    private int level;
    private String filePath;

    public CharacterSummary(String name, String charClass, int level, String filePath) {
        this.name = name;
        this.charClass = charClass;
        this.level = level;
        this.filePath = filePath;
    }

    public String getName() { 
        return name; 
    }

    public String getCharacterClass() { 
        return charClass; 
    }

    public int getLevel() { 
        return level; 
    }

    public String getFilePath() { 
        return filePath; 
    }

    @Override
    public String toString() {
        return name + " - Level " + level + " " + charClass;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

