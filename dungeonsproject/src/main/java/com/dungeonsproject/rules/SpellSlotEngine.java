package com.dungeonsproject.rules;

import java.util.List;
import java.util.Map;

public class SpellSlotEngine {

    public static final String[] SLOT_TITLES = new String[]{
        "First",
        "Second",
        "Third",
        "Fourth",
        "Fifth",
        "Sixth",
        "Seventh",
        "Eighth",
        "Ninth"
    };

    public static final List<String> FULL_CASTER_CLASSES = List.of(
        "Bard",
        "Cleric",
        "Druid",
        "Sorcerer",
        "Wizard",
        "Warlock"
    );

    public static int getMaxSpellLevel(String charClass, int charLevel) {
        if (FULL_CASTER_CLASSES.contains(charClass)) {
            return Math.min(9, (charLevel+1)/2);
        } else {
            return 0;
        }
    }

    public static final Map<Integer, int[]> FULL_CASTER_SLOTS = Map.ofEntries(
        Map.entry( 1, new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0}),
        Map.entry( 2, new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0}),
        Map.entry( 3, new int[]{3, 1, 0, 0, 0, 0, 0, 0, 0}),
        Map.entry( 4, new int[]{3, 2, 0, 0, 0, 0, 0, 0, 0}),
        Map.entry( 5, new int[]{3, 2, 1, 0, 0, 0, 0, 0, 0}),
        Map.entry( 6, new int[]{3, 2, 2, 0, 0, 0, 0, 0, 0}),
        Map.entry( 7, new int[]{3, 2, 2, 1, 0, 0, 0, 0, 0}),
        Map.entry( 8, new int[]{3, 3, 2, 1, 0, 0, 0, 0, 0}),
        Map.entry( 9, new int[]{3, 3, 2, 1, 1, 0, 0, 0, 0}),
        Map.entry(10, new int[]{3, 3, 3, 1, 1, 0, 0, 0, 0}),
        Map.entry(11, new int[]{3, 3, 3, 1, 1, 1, 0, 0, 0}),
        Map.entry(12, new int[]{3, 3, 3, 2, 1, 1, 0, 0, 0}),
        Map.entry(13, new int[]{3, 3, 3, 2, 1, 1, 1, 0, 0}),
        Map.entry(14, new int[]{3, 3, 3, 2, 2, 1, 1, 0, 0}),
        Map.entry(15, new int[]{3, 3, 3, 2, 2, 1, 1, 1, 0}),
        Map.entry(16, new int[]{3, 3, 3, 3, 2, 1, 1, 1, 0}),
        Map.entry(17, new int[]{3, 3, 3, 3, 2, 1, 1, 1, 1}),
        Map.entry(18, new int[]{3, 3, 3, 3, 3, 1, 1, 1, 1}),
        Map.entry(19, new int[]{3, 3, 3, 3, 3, 2, 1, 1, 1}),
        Map.entry(20, new int[]{3, 3, 3, 3, 3, 2, 2, 1, 1})
    );
}
