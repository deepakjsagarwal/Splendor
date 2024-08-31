package com.deepakagarwal.splendor.models;

import static com.deepakagarwal.splendor.utils.Constants.COLORS;
import static com.deepakagarwal.splendor.utils.Constants.NOBEL;
import static com.deepakagarwal.splendor.utils.Constants.colorToInt;

public class Player {
    public String name;
    public int[] cards;
    public int[] tokens;
    public int victoryPoints;

    public Player() {
        this.name = "";
        cards = new int[COLORS];
        tokens = new int[COLORS];
        victoryPoints = 0;
    }

    public boolean canPurchaseCard(Card c) {
        boolean result = false;

        for (int x = 0; x < COLORS; x++) {
            if (c.price[x] <= (this.cards[x] + (c.level == NOBEL ? 0 : this.tokens[x])))
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
        int[] extraTokens = new int[COLORS];
        for (int x = 0; x < this.tokens.length; x++) {
            extraTokens[x] = Math.max(c.price[x] - this.cards[x], 0);
        }
        return extraTokens;
    }

    public void addCardWithScore(Card c) {
        if (colorToInt(c.colour) >= 0)     // Card is not nobel
            this.cards[colorToInt(c.colour)]++;
        this.victoryPoints += c.victoryPoints;
    }

    public void removeTokensForPurchase(int[] extraTokens) {
        for (int x = 0; x < this.tokens.length; x++) {
            this.tokens[x] -= extraTokens[x];
        }
    }

    public void pickTokens(int[] colourAdded) {
        for (int i = 0; i < this.tokens.length; i++) {
            this.tokens[i] += colourAdded[i];
        }
    }

    public int totalNumberOfTokens() {
        int totalTokens = 0;
        for (int token : this.tokens) {
            totalTokens += token;
        }
        return totalTokens;
    }

    public int getCountOfCards() {
        int numOfTotalCards = 0;
        for (int card : this.cards) {
            numOfTotalCards += card;
        }
        return numOfTotalCards;
    }
}
