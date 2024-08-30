package com.deepakagarwal.splendor.models;

import static com.deepakagarwal.splendor.utils.Constants.COLORS;
import static com.deepakagarwal.splendor.utils.Constants.NOBEL;
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

    public boolean canPurchaseCard(Card c) {
        boolean result = false;

        for (int x = 0; x < 5; x++) {
            if (c.priceWithVP[x] <= (this.cards[x] + (c.level == NOBEL ? 0 : this.tokens[x])))
                result = true;
            else return false;
        }
        return result;
    }

    public int[] purchaseCard(Card c) {
        int[] extraTokens = this.findExtraTokens(c);
        this.removeTokensForPurchase(extraTokens);
        this.addCardWithScore(c);
        return extraTokens;
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

    public void addCardWithScore(Card c) {
        if (colorToInt(c.colour) >= 0)     // Card is not nobel
            this.cards[colorToInt(c.colour)]++;
        this.cards[5] += c.priceWithVP[5];
    }

    public void removeTokensForPurchase(int[] extraTokens) {
        for (int x = 0; x < 5; x++) {
            this.tokens[x] -= extraTokens[x];
        }
    }

    public void pickTokens(int[] colourAdded) {
        for (int i = 0; i < colourAdded.length; i++) {
            this.tokens[i] += colourAdded[i];
        }
    }

    public int totalNumberOfTokens() {
        int totalTokens = 0;
        for (int x = 0; x < 5; x++)
            totalTokens += this.tokens[x];
        return totalTokens;
    }
}
