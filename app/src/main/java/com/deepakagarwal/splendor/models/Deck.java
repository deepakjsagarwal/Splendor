package com.deepakagarwal.splendor.models;

import static com.deepakagarwal.splendor.utils.Constants.CARDS_IN_L1_DECK;
import static com.deepakagarwal.splendor.utils.Constants.CARDS_IN_L2_DECK;
import static com.deepakagarwal.splendor.utils.Constants.CARDS_IN_L3_DECK;
import static com.deepakagarwal.splendor.utils.Constants.CARDS_IN_NOBEL_DECK;
import static com.deepakagarwal.splendor.utils.Constants.LEVEL_1;
import static com.deepakagarwal.splendor.utils.Constants.LEVEL_2;
import static com.deepakagarwal.splendor.utils.Constants.LEVEL_3;
import static com.deepakagarwal.splendor.utils.Constants.NOBEL;

import java.util.Random;

public class Deck {
    public Card back;
    Card[] cards;

    int cardsInDeck;

    public Deck(int level) {
        switch (level) {
            case 1:
                resetL1Deck();
                break;
            case 2:
                resetL2Deck();
                break;
            case 3:
                resetL3Deck();
                break;
            case 4:
                resetNobelDeck();
                break;
        }
        shuffle();
    }

    public void resetL1Deck() {
        cardsInDeck = CARDS_IN_L1_DECK;
        cards = new Card[CARDS_IN_L1_DECK];
        cards[0] = new Card("black", new int[]{1, 1, 1, 1, 0, 0}, 1, LEVEL_1);
        cards[1] = new Card("black", new int[]{1, 2, 1, 1, 0, 0}, 2, LEVEL_1);
        cards[2] = new Card("black", new int[]{2, 2, 0, 1, 0, 0}, 3, LEVEL_1);
        cards[3] = new Card("black", new int[]{0, 0, 1, 3, 1, 0}, 4, LEVEL_1);
        cards[4] = new Card("black", new int[]{0, 0, 2, 1, 0, 0}, 5, LEVEL_1);
        cards[5] = new Card("black", new int[]{2, 0, 2, 0, 0, 0}, 6, LEVEL_1);
        cards[6] = new Card("black", new int[]{0, 0, 3, 0, 0, 0}, 7, LEVEL_1);
        cards[7] = new Card("black", new int[]{0, 4, 0, 0, 0, 1}, 8, LEVEL_1);
        cards[8] = new Card("blue", new int[]{1, 0, 1, 1, 1, 0}, 9, LEVEL_1);
        cards[9] = new Card("blue", new int[]{1, 0, 1, 2, 1, 0}, 10, LEVEL_1);
        cards[10] = new Card("blue", new int[]{1, 0, 2, 2, 0, 0}, 11, LEVEL_1);
        cards[11] = new Card("blue", new int[]{0, 1, 3, 1, 0, 0}, 12, LEVEL_1);
        cards[12] = new Card("blue", new int[]{1, 0, 0, 0, 2, 0}, 13, LEVEL_1);
        cards[13] = new Card("blue", new int[]{0, 0, 2, 0, 2, 0}, 14, LEVEL_1);
        cards[14] = new Card("blue", new int[]{0, 0, 0, 0, 3, 0}, 15, LEVEL_1);
        cards[15] = new Card("blue", new int[]{0, 0, 0, 4, 0, 1}, 16, LEVEL_1);
        cards[16] = new Card("pink", new int[]{0, 1, 1, 1, 1, 0}, 17, LEVEL_1);
        cards[17] = new Card("pink", new int[]{0, 1, 2, 1, 1, 0}, 18, LEVEL_1);
        cards[18] = new Card("pink", new int[]{0, 2, 2, 0, 1, 0}, 19, LEVEL_1);
        cards[19] = new Card("pink", new int[]{3, 1, 0, 0, 1, 0}, 20, LEVEL_1);
        cards[20] = new Card("pink", new int[]{0, 0, 0, 2, 1, 0}, 21, LEVEL_1);
        cards[21] = new Card("pink", new int[]{0, 2, 0, 0, 2, 0}, 22, LEVEL_1);
        cards[22] = new Card("pink", new int[]{0, 3, 0, 0, 0, 0}, 23, LEVEL_1);
        cards[23] = new Card("pink", new int[]{0, 0, 4, 0, 0, 1}, 24, LEVEL_1);
        cards[24] = new Card("green", new int[]{1, 1, 0, 1, 1, 0}, 25, LEVEL_1);
        cards[25] = new Card("green", new int[]{1, 1, 0, 1, 2, 0}, 26, LEVEL_1);
        cards[26] = new Card("green", new int[]{0, 1, 0, 2, 2, 0}, 27, LEVEL_1);
        cards[27] = new Card("green", new int[]{1, 3, 1, 0, 0, 0}, 28, LEVEL_1);
        cards[28] = new Card("green", new int[]{2, 1, 0, 0, 0, 0}, 29, LEVEL_1);
        cards[29] = new Card("green", new int[]{0, 2, 0, 2, 0, 0}, 30, LEVEL_1);
        cards[30] = new Card("green", new int[]{0, 0, 0, 3, 0, 0}, 31, LEVEL_1);
        cards[31] = new Card("green", new int[]{0, 0, 0, 0, 4, 1}, 32, LEVEL_1);
        cards[32] = new Card("red", new int[]{1, 1, 1, 0, 1, 0}, 33, LEVEL_1);
        cards[33] = new Card("red", new int[]{2, 1, 1, 0, 1, 0}, 34, LEVEL_1);
        cards[34] = new Card("red", new int[]{2, 0, 1, 0, 2, 0}, 35, LEVEL_1);
        cards[35] = new Card("red", new int[]{1, 0, 0, 1, 3, 0}, 36, LEVEL_1);
        cards[36] = new Card("red", new int[]{0, 2, 1, 0, 0, 0}, 37, LEVEL_1);
        cards[37] = new Card("red", new int[]{2, 0, 0, 2, 0, 0}, 38, LEVEL_1);
        cards[38] = new Card("red", new int[]{3, 0, 0, 0, 0, 0}, 39, LEVEL_1);
        cards[39] = new Card("red", new int[]{4, 0, 0, 0, 0, 1}, 40, LEVEL_1);

        back = new Card("NO", new int[]{25, 25, 25, 25, 25, 0}, 1000, LEVEL_1);
    }

    public void resetL2Deck() {
        cardsInDeck = CARDS_IN_L2_DECK;
        cards = new Card[CARDS_IN_L2_DECK];
        cards[0] = new Card("black", new int[]{3, 2, 2, 0, 0, 1}, 41, LEVEL_2);
        cards[1] = new Card("black", new int[]{3, 0, 3, 0, 2, 1}, 42, LEVEL_2);
        cards[2] = new Card("black", new int[]{0, 1, 4, 2, 0, 2}, 43, LEVEL_2);
        cards[3] = new Card("black", new int[]{0, 0, 5, 3, 0, 2}, 44, LEVEL_2);
        cards[4] = new Card("black", new int[]{5, 0, 0, 0, 0, 2}, 45, LEVEL_2);
        cards[5] = new Card("black", new int[]{0, 0, 0, 0, 6, 3}, 46, LEVEL_2);
        cards[6] = new Card("blue", new int[]{0, 2, 2, 3, 0, 1}, 47, LEVEL_2);
        cards[7] = new Card("blue", new int[]{0, 2, 3, 0, 3, 1}, 48, LEVEL_2);
        cards[8] = new Card("blue", new int[]{5, 3, 0, 0, 0, 2}, 50, LEVEL_2);
        cards[9] = new Card("blue", new int[]{2, 0, 0, 1, 4, 2}, 49, LEVEL_2);
        cards[10] = new Card("blue", new int[]{0, 5, 0, 0, 0, 2}, 51, LEVEL_2);
        cards[11] = new Card("blue", new int[]{0, 6, 0, 0, 0, 3}, 52, LEVEL_2);
        cards[12] = new Card("pink", new int[]{0, 0, 3, 2, 2, 1}, 53, LEVEL_2);
        cards[13] = new Card("pink", new int[]{2, 3, 0, 3, 0, 1}, 54, LEVEL_2);
        cards[14] = new Card("pink", new int[]{0, 0, 1, 4, 2, 2}, 55, LEVEL_2);
        cards[15] = new Card("pink", new int[]{0, 0, 0, 5, 3, 2}, 56, LEVEL_2);
        cards[16] = new Card("pink", new int[]{0, 0, 0, 5, 0, 2}, 57, LEVEL_2);
        cards[17] = new Card("pink", new int[]{6, 0, 0, 0, 0, 3}, 58, LEVEL_2);
        cards[18] = new Card("green", new int[]{3, 0, 2, 3, 0, 1}, 60, LEVEL_2);
        cards[19] = new Card("green", new int[]{2, 3, 0, 0, 2, 1}, 59, LEVEL_2);
        cards[20] = new Card("green", new int[]{4, 2, 0, 0, 1, 2}, 61, LEVEL_2);
        cards[21] = new Card("green", new int[]{0, 5, 3, 0, 0, 2}, 62, LEVEL_2);
        cards[22] = new Card("green", new int[]{0, 0, 5, 0, 0, 2}, 63, LEVEL_2);
        cards[23] = new Card("green", new int[]{0, 0, 6, 0, 0, 3}, 64, LEVEL_2);
        cards[24] = new Card("red", new int[]{2, 0, 0, 2, 3, 1}, 65, LEVEL_2);
        cards[25] = new Card("red", new int[]{0, 3, 0, 2, 3, 1}, 66, LEVEL_2);
        cards[26] = new Card("red", new int[]{1, 4, 2, 0, 0, 2}, 67, LEVEL_2);
        cards[27] = new Card("red", new int[]{3, 0, 0, 0, 5, 2}, 68, LEVEL_2);
        cards[28] = new Card("red", new int[]{0, 0, 0, 0, 5, 2}, 69, LEVEL_2);
        cards[29] = new Card("red", new int[]{0, 0, 0, 6, 0, 3}, 70, LEVEL_2);

        back = new Card("NO", new int[]{25, 25, 25, 25, 25, 0}, 1001, LEVEL_2);
    }

    public void resetL3Deck() {
        cardsInDeck = CARDS_IN_L3_DECK;
        cards = new Card[CARDS_IN_L3_DECK];
        cards[0] = new Card("black", new int[]{3, 3, 5, 3, 0, 3}, 71, LEVEL_3);
        cards[1] = new Card("black", new int[]{0, 0, 0, 7, 0, 4}, 72, LEVEL_3);
        cards[2] = new Card("black", new int[]{0, 0, 3, 6, 3, 4}, 73, LEVEL_3);
        cards[3] = new Card("black", new int[]{0, 0, 0, 7, 3, 5}, 74, LEVEL_3);
        cards[4] = new Card("blue", new int[]{3, 0, 3, 3, 5, 3}, 75, LEVEL_3);
        cards[5] = new Card("blue", new int[]{7, 0, 0, 0, 0, 4}, 76, LEVEL_3);
        cards[6] = new Card("blue", new int[]{6, 3, 0, 0, 3, 4}, 77, LEVEL_3);
        cards[7] = new Card("blue", new int[]{7, 3, 0, 0, 0, 5}, 78, LEVEL_3);
        cards[8] = new Card("pink", new int[]{0, 3, 3, 5, 3, 3}, 79, LEVEL_3);
        cards[9] = new Card("pink", new int[]{0, 0, 0, 0, 7, 4}, 80, LEVEL_3);
        cards[10] = new Card("pink", new int[]{3, 0, 0, 3, 6, 4}, 81, LEVEL_3);
        cards[11] = new Card("pink", new int[]{3, 0, 0, 0, 7, 5}, 82, LEVEL_3);
        cards[12] = new Card("green", new int[]{5, 3, 0, 3, 3, 3}, 83, LEVEL_3);
        cards[13] = new Card("green", new int[]{0, 7, 0, 0, 0, 4}, 84, LEVEL_3);
        cards[14] = new Card("green", new int[]{3, 6, 3, 0, 0, 4}, 85, LEVEL_3);
        cards[15] = new Card("green", new int[]{0, 7, 3, 0, 0, 5}, 86, LEVEL_3);
        cards[16] = new Card("red", new int[]{3, 5, 3, 0, 3, 3}, 87, LEVEL_3);
        cards[17] = new Card("red", new int[]{0, 0, 7, 0, 0, 4}, 88, LEVEL_3);
        cards[18] = new Card("red", new int[]{0, 3, 6, 3, 0, 4}, 89, LEVEL_3);
        cards[19] = new Card("red", new int[]{0, 0, 7, 3, 0, 5}, 90, LEVEL_3);

        back = new Card("NO", new int[]{25, 25, 25, 25, 25, 0}, 1002, LEVEL_3);
    }

    public void resetNobelDeck() {
        cardsInDeck = CARDS_IN_NOBEL_DECK;
        cards = new Card[CARDS_IN_NOBEL_DECK];
        cards[0] = new Card("nobel", new int[]{3, 3, 0, 3, 0, 3}, 91, NOBEL);
        cards[1] = new Card("nobel", new int[]{0, 3, 3, 0, 3, 3}, 92, NOBEL);
        cards[2] = new Card("nobel", new int[]{0, 3, 0, 3, 3, 3}, 93, NOBEL);
        cards[3] = new Card("nobel", new int[]{0, 0, 0, 4, 4, 3}, 94, NOBEL);
        cards[4] = new Card("nobel", new int[]{0, 0, 4, 0, 4, 3}, 95, NOBEL);
        cards[5] = new Card("nobel", new int[]{4, 4, 0, 0, 0, 3}, 96, NOBEL);
        cards[6] = new Card("nobel", new int[]{0, 4, 0, 4, 0, 3}, 97, NOBEL);
        cards[7] = new Card("nobel", new int[]{4, 0, 4, 0, 0, 3}, 98, NOBEL);
        cards[8] = new Card("nobel", new int[]{4, 0, 0, 4, 0, 3}, 99, NOBEL);

        back = new Card("NO", new int[]{25, 25, 25, 25, 25, 0}, 1003, NOBEL);
    }


    public void shuffle() {
        Random random = new Random();

        for (int i = 0; i < cards.length; i++) {
            int randomValue = i + random.nextInt(cards.length - i);
            Card randomCard = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;
        }
    }

    public Card drawCard() {
        if (isEmpty()) {
            return back;
        } else {
            return cards[--cardsInDeck];
        }
    }

    public boolean isEmpty() {
        return cardsInDeck == 0;
    }
}
