package com.deepakagarwal.splendor.models;

public class Game {

    public Deck[] levelDeck;
//    public Deck nobelDeck;

    final int LEVELS = 4;

    public int currentPlayer = 0;
    public int numOfPlayers;
    public int[][][] playerTable;
    public String[] playerNames;

    public Game(int numOfPlayers){
        this.numOfPlayers = numOfPlayers;

        levelDeck = new Deck[LEVELS];

        for (int i = 0; i <LEVELS; i++) {
            levelDeck[i] = new Deck(i+1);
        }

        currentPlayer = 0;
    }

    public static boolean allDifferentToken(int[] colour,int numOfDifferentTokens){
        int count = 0;
        for(int x =0;x<5;x++){
            if(colour[x] == 1) count++;
        }
        return count == numOfDifferentTokens;
    }
}
