package com.deepakagarwal.splendor.cardsParameters;

import java.util.Random;

public class gameDeck {
    cardsParams[] l1cards;
    cardsParams[] l2cards;
    cardsParams[] l3cards;
    cardsParams[] nobel;
    cardsParams l1back;
    cardsParams l2back;
    cardsParams l3back;
    public static cardsParams nobelback;

    int cardsInL1Deck =40;
    int cardsInL2Deck = 30;
    int cardsInL3Deck = 20;
    int cardsInNobelDeck =9;

    public gameDeck(){
        l1cards = new cardsParams[40];
        l2cards = new cardsParams[30];
        l3cards = new cardsParams[20];
        nobel = new cardsParams[9];
        l1back = new cardsParams("NO", new int[]{25, 25, 25, 25, 25, 0},1000);
        l2back = new cardsParams("NO",new int[]{25,25,25,25,25,0},1001);
        l3back = new cardsParams("NO",new int[]{25,25,25,25,25,0},1002);
        nobelback = new cardsParams("NO",new int[]{25,25,25,25,25,0},1003);
    }

    public void reset() {
        l1cards[0] = new cardsParams("black",new int[]{ 1, 1, 1, 1, 0, 0},1);
        l1cards[1] = new cardsParams("black", new int[]{1, 2, 1, 1, 0, 0},2);
        l1cards[2] = new cardsParams("black",new int[]{ 2, 2, 0, 1, 0, 0},3);
        l1cards[3] = new cardsParams("black", new int[]{0, 0, 1, 3, 1, 0},4);
        l1cards[4] = new cardsParams("black", new int[]{0, 0, 2, 1, 0, 0},5);
        l1cards[5] = new cardsParams("black", new int[]{2, 0, 2, 0, 0, 0},6);
        l1cards[6] = new cardsParams("black", new int[]{0, 0, 3, 0, 0, 0},7);
        l1cards[7] = new cardsParams("black", new int[]{0, 4, 0, 0, 0, 1},8);
        l1cards[8] = new cardsParams("blue", new int[]{1,0,1,1,1,0},9);
        l1cards[9] = new cardsParams("blue", new int[]{1,0,1,2,1,0},10);
        l1cards[10] = new cardsParams("blue", new int[]{1,0,2,2,0,0},11);
        l1cards[11] = new cardsParams("blue", new int[]{0,1,3,1,0,0},12);
        l1cards[12] = new cardsParams("blue", new int[]{1,0,0,0,2,0},13);
        l1cards[13] = new cardsParams("blue", new int[]{0,0,2,0,2,0},14);
        l1cards[14] = new cardsParams("blue", new int[]{0,0,0,0,3,0},15);
        l1cards[15] = new cardsParams("blue", new int[]{0,0,0,4,0,1},16);
        l1cards[16] = new cardsParams("pink", new int[]{0,1,1,1,1,0},17);
        l1cards[17] = new cardsParams("pink", new int[]{0,1,2,1,1,0},18);
        l1cards[18] = new cardsParams("pink",new int[]{0,2,2,0,1,0},19 );
        l1cards[19] = new cardsParams("pink",new int[]{3,1,0,0,1,0},20 );
        l1cards[20] = new cardsParams("pink",new int[]{0,0,0,2,1,0},21 );
        l1cards[21] = new cardsParams("pink",new int[]{0,2,0,0,2,0},22 );
        l1cards[22] = new cardsParams("pink", new int[]{0,3,0,0,0,0},23);
        l1cards[23] = new cardsParams("pink", new int[]{0,0,4,0,0,1},24);
        l1cards[24] = new cardsParams("green", new int[]{1,1,0,1,1,0},25);
        l1cards[25] = new cardsParams("green", new int[]{1,1,0,1,2,0},26);
        l1cards[26] = new cardsParams("green", new int[]{0,1,0,2,2,0},27);
        l1cards[27] = new cardsParams("green", new int[]{1,3,1,0,0,0},28);
        l1cards[28] = new cardsParams("green", new int[]{2,1,0,0,0,0},29);
        l1cards[29] = new cardsParams("green", new int[]{0,2,0,2,0,0},30);
        l1cards[30] = new cardsParams("green", new int[]{0,0,0,3,0,0},31);
        l1cards[31] = new cardsParams("green", new int[]{0,0,0,0,4,1},32);
        l1cards[32] = new cardsParams("red", new int[]{1,1,1,0,1,0},33);
        l1cards[33] = new cardsParams("red", new int[]{2,1,1,0,1,0},34);
        l1cards[34] = new cardsParams("red", new int[]{2,0,1,0,2,0},35);
        l1cards[35] = new cardsParams("red", new int[]{1,0,0,1,3,0},36);
        l1cards[36] = new cardsParams("red", new int[]{0,2,1,0,0,0},37);
        l1cards[37] = new cardsParams("red", new int[]{2,0,0,2,0,0},38);
        l1cards[38] = new cardsParams("red", new int[]{3,0,0,0,0,0},39);
        l1cards[39] = new cardsParams("red", new int[]{4,0,0,0,0,1},40);

        l2cards[0] = new cardsParams("black",new int[]{3,2,2,0,0,1},41);
        l2cards[1] = new cardsParams("black",new int[]{3,0,3,0,2,1},42);
        l2cards[2] = new cardsParams("black",new int[]{0,1,4,2,0,2},43);
        l2cards[3] = new cardsParams("black",new int[]{0,0,5,3,0,2},44);
        l2cards[4] = new cardsParams("black",new int[]{5,0,0,0,0,2},45);
        l2cards[5] = new cardsParams("black",new int[]{0,0,0,0,6,3},46);
        l2cards[6] = new cardsParams("blue",new int[]{0,2,2,3,0,1},47);
        l2cards[7] = new cardsParams("blue",new int[]{0,2,3,0,3,1},48);
        l2cards[8] = new cardsParams("blue",new int[]{5,3,0,0,0,2},50);
        l2cards[9] = new cardsParams("blue",new int[]{2,0,0,1,4,2},49);
        l2cards[10] = new cardsParams("blue",new int[]{0,5,0,0,0,2},51);
        l2cards[11] = new cardsParams("blue",new int[]{0,6,0,0,0,3},52);
        l2cards[12] = new cardsParams("pink",new int[]{0,0,3,2,2,1},53);
        l2cards[13] = new cardsParams("pink",new int[]{2,3,0,3,0,1},54);
        l2cards[14] = new cardsParams("pink",new int[]{0,0,1,4,2,2},55);
        l2cards[15] = new cardsParams("pink",new int[]{0,0,0,5,3,2},56);
        l2cards[16] = new cardsParams("pink",new int[]{0,0,0,5,0,2},57);
        l2cards[17] = new cardsParams("pink",new int[]{6,0,0,0,0,3},58);
        l2cards[18] = new cardsParams("green",new int[]{3,0,2,3,0,1},60);
        l2cards[19] = new cardsParams("green",new int[]{2,3,0,0,2,1},59);
        l2cards[20] = new cardsParams("green",new int[]{4,2,0,0,1,2},61);
        l2cards[21] = new cardsParams("green",new int[]{0,5,3,0,0,2},62);
        l2cards[22] = new cardsParams("green",new int[]{0,0,5,0,0,2},63);
        l2cards[23] = new cardsParams("green",new int[]{0,0,6,0,0,3},64);
        l2cards[24] = new cardsParams("red",new int[]{2,0,0,2,3,1},65);
        l2cards[25] = new cardsParams("red",new int[]{0,3,0,2,3,1},66);
        l2cards[26] = new cardsParams("red",new int[]{1,4,2,0,0,2},67);
        l2cards[27] = new cardsParams("red",new int[]{3,0,0,0,5,2},68);
        l2cards[28] = new cardsParams("red",new int[]{0,0,0,0,5,2},69);
        l2cards[29] = new cardsParams("red",new int[]{0,0,0,6,0,3},70);

        l3cards[0] = new cardsParams("black",new int[]{3,3,5,3,0,3},71);
        l3cards[1] = new cardsParams("black",new int[]{0,0,0,7,0,4},72);
        l3cards[2] = new cardsParams("black",new int[]{0,0,3,6,3,4},73);
        l3cards[3] = new cardsParams("black",new int[]{0,0,0,7,3,5},74);
        l3cards[4] = new cardsParams("blue",new int[]{3,0,3,3,5,3},75);
        l3cards[5] = new cardsParams("blue",new int[]{7,0,0,0,0,4},76);
        l3cards[6] = new cardsParams("blue",new int[]{6,3,0,0,3,4},77);
        l3cards[7] = new cardsParams("blue",new int[]{7,3,0,0,0,5},78);
        l3cards[8] = new cardsParams("pink",new int[]{0,3,3,5,3,3},79);
        l3cards[9] = new cardsParams("pink",new int[]{0,0,0,0,7,4},80);
        l3cards[10] = new cardsParams("pink",new int[]{3,0,0,3,6,4},81);
        l3cards[11] = new cardsParams("pink",new int[]{3,0,0,0,7,5},82);
        l3cards[12] = new cardsParams("green",new int[]{5,3,0,3,3,3},83);
        l3cards[13] = new cardsParams("green",new int[]{0,7,0,0,0,4},84);
        l3cards[14] = new cardsParams("green",new int[]{3,6,3,0,0,4},85);
        l3cards[15] = new cardsParams("green",new int[]{0,7,3,0,0,5},86);
        l3cards[16] = new cardsParams("red",new int[]{3,5,3,0,3,3},87);
        l3cards[17] = new cardsParams("red",new int[]{0,0,7,0,0,4},88);
        l3cards[18] = new cardsParams("red",new int[]{0,3,6,3,0,4},89);
        l3cards[19] = new cardsParams("red",new int[]{0,0,7,3,0,5},90);

        nobel[0] = new cardsParams("nobel",new int[]{3,3,0,3,0,3},91);
        nobel[1] = new cardsParams("nobel",new int[]{0,3,3,0,3,3},92);
        nobel[2] = new cardsParams("nobel",new int[]{0,3,0,3,3,3},93);
        nobel[3] = new cardsParams("nobel",new int[]{0,0,0,4,4,3},94);
        nobel[4] = new cardsParams("nobel",new int[]{0,0,4,0,4,3},95);
        nobel[5] = new cardsParams("nobel",new int[]{4,4,0,0,0,3},96);
        nobel[6] = new cardsParams("nobel",new int[]{0,4,0,4,0,3},97);
        nobel[7] = new cardsParams("nobel",new int[]{4,0,4,0,0,3},98);
        nobel[8] = new cardsParams("nobel",new int[]{4,0,0,4,0,3},99);
    }


    public void shuffle(){
        Random random = new Random();

        for(int i = 0; i<l1cards.length;i++){
            int randomValue = i+random.nextInt(l1cards.length-i);
            cardsParams randomCard =  l1cards[randomValue];
            l1cards[randomValue] = l1cards[i];
            l1cards[i] = randomCard;
        }
        for(int i = 0; i<l2cards.length;i++){
            int randomValue = i+random.nextInt(l2cards.length-i);
            cardsParams randomCard =  l2cards[randomValue];
            l2cards[randomValue] = l2cards[i];
            l2cards[i] = randomCard;
        }
        for(int i = 0; i<l3cards.length;i++){
            int randomValue = i+random.nextInt(l3cards.length-i);
            cardsParams randomCard =  l3cards[randomValue];
            l3cards[randomValue] = l3cards[i];
            l3cards[i] = randomCard;
        }
        for(int i = 0; i<nobel.length;i++){
            int randomValue = i+random.nextInt(nobel.length-i);
            cardsParams randomCard =  nobel[randomValue];
            nobel[randomValue] = nobel[i];
            nobel[i] = randomCard;
        }
    }
    public cardsParams drawCard(int x){
        if(isEmpty(x)){
            switch(x) {
                case 1:
                    return l1back;
                case 2:
                    return l2back;
                case 3:
                    return l3back;
            }
        }
        else{
            switch(x) {
                case 1:
                    return l1cards[--cardsInL1Deck];
                case 2:
                    return l2cards[--cardsInL2Deck];
                case 3:
                    return l3cards[--cardsInL3Deck];
                case 4:
                    return nobel[--cardsInNobelDeck];
            }
        }
       return null;
    }

    public int drawCardImage(cardsParams card,int x){
        if(isEmpty(x)){
            switch(x) {
                case 1:
                    return 1000;
                case 2:
                    return 1001;
                case 3:
                    return 1002;
            }
        }
        return card.idNumber;
    }

    public boolean isEmpty(int x){
        switch(x){
            case 1:
                return cardsInL1Deck ==0;
            case 2:
                return cardsInL2Deck ==0;
            case 3:
                return cardsInL3Deck ==0;
            default:
                return false;
        }
    }
}
