package com.dungeonsproject.rules;

import java.util.HashMap;
import java.util.Map;

import com.dungeonsproject.characterdata.CharacterSheet;

public class CharacterBonusEngine {

    public static Map<String, Integer> computeSkillModifiers(CharacterSheet data) {
        Map<String, Integer> result = new HashMap<>();
        int profBonus = proficiencyBonus(data.getLevel());

        for (Skill skill : Skill.values()) {
            String type = skill.name;
            Ability ability = skill.ability;

            int mod = data.getStats().getModifier(ability);

            if (data.getProficiences().contains(type)) {
                mod += profBonus;
            }
            if (data.getExpertise().contains(type)) {
                mod += profBonus;
            }
            result.put(type, mod);
        }
        return result;
    }

    public static int proficiencyBonus(int level) {
        if (level >= 17) return 6;
        if (level >= 13) return 5;
        if (level >= 9) return 4;
        if (level >= 5) return 3;
        return 2;
    }
}
