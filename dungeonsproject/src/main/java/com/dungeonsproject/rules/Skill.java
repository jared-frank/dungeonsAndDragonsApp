package com.dungeonsproject.rules;

public enum Skill {
    ACROBATICS("Acrobatics", Ability.DEX),
    ANIMAL_HANDLING("Animal Handling", Ability.WIS),
    ARCANA("Arcana", Ability.ITL),
    ATHLETICS("Athletics", Ability.STR),
    DECEPTION("Deception", Ability.CHA),
    HISTORY("History", Ability.ITL),
    INSIGHT("Insight", Ability.WIS),
    INTIMIDATION("Intimidation", Ability.CHA),
    INVESTIGATION("Investigation", Ability.ITL),
    MEDICINE("Medicine", Ability.WIS),
    NATURE("Nature", Ability.ITL),
    PERCEPTION("Perception", Ability.WIS),
    PERFORMANCE("Performance", Ability.CHA),
    PERSUASION("Persuasion", Ability.CHA),
    RELIGION("Religion", Ability.ITL),
    SLEIGHT_OF_HAND("Sleight of Hand", Ability.DEX),
    STEALTH("Stealth", Ability.DEX),
    SURVIVAL("Survival", Ability.WIS);

    public final String name;
    public final Ability ability;

    Skill(String name, Ability ability) {
        this.name = name;
        this.ability = ability;
    }


}
