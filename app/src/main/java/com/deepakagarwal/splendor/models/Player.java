package com.deepakagarwal.splendor.models;

import static com.deepakagarwal.splendor.utils.Constants.COLORS;
import static com.deepakagarwal.splendor.utils.Constants.colorToInt;

public class Player {
    public String name;
    public int[] cards;
    public int[] tokens;

    public Player() {
        this.name = "";
        cards = new int[COLORS + 1]; //Colors+VP
        tokens = new int[COLORS];
    }

    public boolean checkPrice(Card c, boolean isItNobel) {
        boolean result = false;
        if (!isItNobel) {
            for (int x = 0; x < 5; x++) {
                if (c.priceWithVP[x] <= this.cards[x] + this.tokens[x])
                    result = true;
                else return false;
            }
        } else {
            for (int x = 0; x < 5; x++) {
                if (c.priceWithVP[x] <= this.cards[x])
                    result = true;
                else return false;
            }
        }
        return result;
    }

    public int[] findExtraTokens(Card c) {
        int[] extraTokens = new int[5];
        for (int x = 0; x < 5; x++) {
            if (c.priceWithVP[x] - this.cards[x] >= 0)
                extraTokens[x] = c.priceWithVP[x] - this.cards[x];
            else
                extraTokens[x] = 0;
        }
        return extraTokens;
    }

    public void addCardWithScoreToCurrentPlayerTable(Card c) {
        this.cards[colorToInt(c.colour)]++;
        this.cards[5] += c.priceWithVP[5];
    }

    public int[] removeTokenFromTableOfCurrentPlayer(int[] extraTokens) {
        for (int x = 0; x < 5; x++) {
            this.tokens[x] -= extraTokens[x];
        }
        return this.tokens;
    }
}
