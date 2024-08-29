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

    public static final int COUNT_TABLE_LEVEL_CARD = 4;
    public static final int COUNT_TABLE_NOBEL = 3;

    public static int colorToInt(String color) {
        Map<String, Integer> colors = new HashMap<>();
        colors.put("pink", 0);
        colors.put("blue", 1);
        colors.put("green", 2);
        colors.put("red", 3);
        colors.put("black", 4);

        return colors.get(color) != null ? colors.get(color) : -1;
    }

    public static String intToColor(int color) {
        Map<Integer, String> colors = new HashMap<>();
        colors.put(0, "pink");
        colors.put(1, "blue");
        colors.put(2, "green");
        colors.put(3, "red");
        colors.put(4, "black");
        String colorString = colors.get(color);

        return colorString != null ? colorString : "unknown";
    }
}
