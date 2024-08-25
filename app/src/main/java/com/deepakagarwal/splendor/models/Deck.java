package com.deepakagarwal.splendor.models;

import java.util.Random;

public class Deck {
    Card[] cards;
    public Card back;
//    public static Card back;

    final int CARDS_IN_L1_DECK = 40;
    final int CARDS_IN_L2_DECK = 30;
    final int CARDS_IN_L3_DECK = 20;
    final int CARDS_IN_NOBEL_DECK = 9;

    int cardsInDeck;

    public Deck(int level){
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
        cards[0] = new Card("black",new int[]{ 1, 1, 1, 1, 0, 0},1);
        cards[1] = new Card("black", new int[]{1, 2, 1, 1, 0, 0},2);
        cards[2] = new Card("black",new int[]{ 2, 2, 0, 1, 0, 0},3);
        cards[3] = new Card("black", new int[]{0, 0, 1, 3, 1, 0},4);
        cards[4] = new Card("black", new int[]{0, 0, 2, 1, 0, 0},5);
        cards[5] = new Card("black", new int[]{2, 0, 2, 0, 0, 0},6);
        cards[6] = new Card("black", new int[]{0, 0, 3, 0, 0, 0},7);
        cards[7] = new Card("black", new int[]{0, 4, 0, 0, 0, 1},8);
        cards[8] = new Card("blue", new int[]{1,0,1,1,1,0},9);
        cards[9] = new Card("blue", new int[]{1,0,1,2,1,0},10);
        cards[10] = new Card("blue", new int[]{1,0,2,2,0,0},11);
        cards[11] = new Card("blue", new int[]{0,1,3,1,0,0},12);
        cards[12] = new Card("blue", new int[]{1,0,0,0,2,0},13);
        cards[13] = new Card("blue", new int[]{0,0,2,0,2,0},14);
        cards[14] = new Card("blue", new int[]{0,0,0,0,3,0},15);
        cards[15] = new Card("blue", new int[]{0,0,0,4,0,1},16);
        cards[16] = new Card("pink", new int[]{0,1,1,1,1,0},17);
        cards[17] = new Card("pink", new int[]{0,1,2,1,1,0},18);
        cards[18] = new Card("pink",new int[]{0,2,2,0,1,0},19 );
        cards[19] = new Card("pink",new int[]{3,1,0,0,1,0},20 );
        cards[20] = new Card("pink",new int[]{0,0,0,2,1,0},21 );
        cards[21] = new Card("pink",new int[]{0,2,0,0,2,0},22 );
        cards[22] = new Card("pink", new int[]{0,3,0,0,0,0},23);
        cards[23] = new Card("pink", new int[]{0,0,4,0,0,1},24);
        cards[24] = new Card("green", new int[]{1,1,0,1,1,0},25);
        cards[25] = new Card("green", new int[]{1,1,0,1,2,0},26);
        cards[26] = new Card("green", new int[]{0,1,0,2,2,0},27);
        cards[27] = new Card("green", new int[]{1,3,1,0,0,0},28);
        cards[28] = new Card("green", new int[]{2,1,0,0,0,0},29);
        cards[29] = new Card("green", new int[]{0,2,0,2,0,0},30);
        cards[30] = new Card("green", new int[]{0,0,0,3,0,0},31);
        cards[31] = new Card("green", new int[]{0,0,0,0,4,1},32);
        cards[32] = new Card("red", new int[]{1,1,1,0,1,0},33);
        cards[33] = new Card("red", new int[]{2,1,1,0,1,0},34);
        cards[34] = new Card("red", new int[]{2,0,1,0,2,0},35);
        cards[35] = new Card("red", new int[]{1,0,0,1,3,0},36);
        cards[36] = new Card("red", new int[]{0,2,1,0,0,0},37);
        cards[37] = new Card("red", new int[]{2,0,0,2,0,0},38);
        cards[38] = new Card("red", new int[]{3,0,0,0,0,0},39);
        cards[39] = new Card("red", new int[]{4,0,0,0,0,1},40);

        back = new Card("NO", new int[]{25, 25, 25, 25, 25, 0},1000);
    }
    public void resetL2Deck() {
        cardsInDeck = CARDS_IN_L2_DECK;
        cards = new Card[CARDS_IN_L2_DECK];
        cards[0] = new Card("black",new int[]{3,2,2,0,0,1},41);
        cards[1] = new Card("black",new int[]{3,0,3,0,2,1},42);
        cards[2] = new Card("black",new int[]{0,1,4,2,0,2},43);
        cards[3] = new Card("black",new int[]{0,0,5,3,0,2},44);
        cards[4] = new Card("black",new int[]{5,0,0,0,0,2},45);
        cards[5] = new Card("black",new int[]{0,0,0,0,6,3},46);
        cards[6] = new Card("blue",new int[]{0,2,2,3,0,1},47);
        cards[7] = new Card("blue",new int[]{0,2,3,0,3,1},48);
        cards[8] = new Card("blue",new int[]{5,3,0,0,0,2},50);
        cards[9] = new Card("blue",new int[]{2,0,0,1,4,2},49);
        cards[10] = new Card("blue",new int[]{0,5,0,0,0,2},51);
        cards[11] = new Card("blue",new int[]{0,6,0,0,0,3},52);
        cards[12] = new Card("pink",new int[]{0,0,3,2,2,1},53);
        cards[13] = new Card("pink",new int[]{2,3,0,3,0,1},54);
        cards[14] = new Card("pink",new int[]{0,0,1,4,2,2},55);
        cards[15] = new Card("pink",new int[]{0,0,0,5,3,2},56);
        cards[16] = new Card("pink",new int[]{0,0,0,5,0,2},57);
        cards[17] = new Card("pink",new int[]{6,0,0,0,0,3},58);
        cards[18] = new Card("green",new int[]{3,0,2,3,0,1},60);
        cards[19] = new Card("green",new int[]{2,3,0,0,2,1},59);
        cards[20] = new Card("green",new int[]{4,2,0,0,1,2},61);
        cards[21] = new Card("green",new int[]{0,5,3,0,0,2},62);
        cards[22] = new Card("green",new int[]{0,0,5,0,0,2},63);
        cards[23] = new Card("green",new int[]{0,0,6,0,0,3},64);
        cards[24] = new Card("red",new int[]{2,0,0,2,3,1},65);
        cards[25] = new Card("red",new int[]{0,3,0,2,3,1},66);
        cards[26] = new Card("red",new int[]{1,4,2,0,0,2},67);
        cards[27] = new Card("red",new int[]{3,0,0,0,5,2},68);
        cards[28] = new Card("red",new int[]{0,0,0,0,5,2},69);
        cards[29] = new Card("red",new int[]{0,0,0,6,0,3},70);

        back = new Card("NO",new int[]{25,25,25,25,25,0},1001);
    }
    public void resetL3Deck() {
        cardsInDeck = CARDS_IN_L3_DECK;
        cards = new Card[CARDS_IN_L3_DECK];
        cards[0] = new Card("black",new int[]{3,3,5,3,0,3},71);
        cards[1] = new Card("black",new int[]{0,0,0,7,0,4},72);
        cards[2] = new Card("black",new int[]{0,0,3,6,3,4},73);
        cards[3] = new Card("black",new int[]{0,0,0,7,3,5},74);
        cards[4] = new Card("blue",new int[]{3,0,3,3,5,3},75);
        cards[5] = new Card("blue",new int[]{7,0,0,0,0,4},76);
        cards[6] = new Card("blue",new int[]{6,3,0,0,3,4},77);
        cards[7] = new Card("blue",new int[]{7,3,0,0,0,5},78);
        cards[8] = new Card("pink",new int[]{0,3,3,5,3,3},79);
        cards[9] = new Card("pink",new int[]{0,0,0,0,7,4},80);
        cards[10] = new Card("pink",new int[]{3,0,0,3,6,4},81);
        cards[11] = new Card("pink",new int[]{3,0,0,0,7,5},82);
        cards[12] = new Card("green",new int[]{5,3,0,3,3,3},83);
        cards[13] = new Card("green",new int[]{0,7,0,0,0,4},84);
        cards[14] = new Card("green",new int[]{3,6,3,0,0,4},85);
        cards[15] = new Card("green",new int[]{0,7,3,0,0,5},86);
        cards[16] = new Card("red",new int[]{3,5,3,0,3,3},87);
        cards[17] = new Card("red",new int[]{0,0,7,0,0,4},88);
        cards[18] = new Card("red",new int[]{0,3,6,3,0,4},89);
        cards[19] = new Card("red",new int[]{0,0,7,3,0,5},90);

        back = new Card("NO",new int[]{25,25,25,25,25,0},1002);
    }
    public void resetNobelDeck() {
        cardsInDeck = CARDS_IN_NOBEL_DECK;
        cards = new Card[CARDS_IN_NOBEL_DECK];
        cards[0] = new Card("nobel",new int[]{3,3,0,3,0,3},91);
        cards[1] = new Card("nobel",new int[]{0,3,3,0,3,3},92);
        cards[2] = new Card("nobel",new int[]{0,3,0,3,3,3},93);
        cards[3] = new Card("nobel",new int[]{0,0,0,4,4,3},94);
        cards[4] = new Card("nobel",new int[]{0,0,4,0,4,3},95);
        cards[5] = new Card("nobel",new int[]{4,4,0,0,0,3},96);
        cards[6] = new Card("nobel",new int[]{0,4,0,4,0,3},97);
        cards[7] = new Card("nobel",new int[]{4,0,4,0,0,3},98);
        cards[8] = new Card("nobel",new int[]{4,0,0,4,0,3},99);

        back = new Card("NO",new int[]{25,25,25,25,25,0},1003);
    }


    public void shuffle(){
        Random random = new Random();

        for(int i = 0; i< cards.length; i++){
            int randomValue = i+random.nextInt(cards.length-i);
            Card randomCard =  cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;
        }
    }
    public Card drawCard(){
        if(isEmpty()){
                    return back;
        }
        else{
                    return cards[--cardsInDeck];

        }
    }

    public int drawCardImage(Card card){
        if(isEmpty()){
            return back.idNumber;
        }
        return card.idNumber;
    }

    public boolean isEmpty(){

                return cardsInDeck ==0;

    }
}
