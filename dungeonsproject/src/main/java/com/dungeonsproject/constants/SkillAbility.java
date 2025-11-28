package com.dungeonsproject.constants;

public enum SkillAbility {
    ACROBATICS("Acrobatics", Ability.DEX),
    ANIMAL_HANDLING("Animal Handling", Ability.WIS),
    ARCANA("Arcana", Ability.ITL),
    ATHLETICS("Athletics", Ability.STR),
    DECEPTION("Deception", Ability.CHA),
    HISTORY("History", Ability.ITL),
    MEDICINE("Medicine", Ability.WIS),
    NATURE("Nature", Ability.ITL),
    PERCEPTION("Perception", Ability.WIS),
    PERFORMANCE("Performance", Ability.CHA),
    PERSUASION("Persuasion", Ability.CHA),
    RELIGION("Religion", Ability.ITL),
    SLEIGHT_OF_HAND("Sleight of Hand", Ability.DEX),
    STEALTH("Stealth", Ability.DEX),
    SURVIVAL("Survival", Ability.WIS);

    private final String name;
    private final Ability ability;

    SkillAbility(String name, Ability ability) {
        this.name = name;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public Ability getAbility() {
        return ability;
    }
}
