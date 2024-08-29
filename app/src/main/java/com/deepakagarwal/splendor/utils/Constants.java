package com.deepakagarwal.splendor.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final int COLORS = 5;

    public static final int LEVELS = 4;
    public static final int LEVEL_1 = 0;
    public static final int LEVEL_2 = 1;
    public static final int LEVEL_3 = 2;
    public static final int NOBEL = 3;

    public static final int CARDS_IN_L1_DECK = 40;
    public static final int CARDS_IN_L2_DECK = 30;
    public static final int CARDS_IN_L3_DECK = 20;
    public static final int CARDS_IN_NOBEL_DECK = 9;

    public static int colorToInt(String color) {
        Map<String, Integer> colors = new HashMap<>();
        colors.put("pink", 0);
        colors.put("blue", 1);
        colors.put("green", 2);
        colors.put("red", 3);
        colors.put("black", 4);

        return colors.get(color) != null ? colors.get(color) : -1;
    }
}
