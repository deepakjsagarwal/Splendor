package com.deepakagarwal.splendor.models;

import static com.deepakagarwal.splendor.AskNumberOfPlayers.game;
import static com.deepakagarwal.splendor.utils.Constants.LEVELS;

public class Game {


    public Deck[] levelDeck;

    public int currentPlayer;
//    public int[][][] playerTable;
//    public String[] playerNames;
    public Player[] players;

    public Game(int numOfPlayers) {
        players = new Player[numOfPlayers];

        for (int i = 0; i < numOfPlayers; i++) {
            players[i] = new Player();
        }

        levelDeck = new Deck[LEVELS];

        for (int i = 0; i < LEVELS; i++) {
            levelDeck[i] = new Deck(i + 1);
        }

        currentPlayer = 0;
    }

    public static boolean allDifferentToken(int[] colour, int numOfDifferentTokens) {
        int count = 0;
        for (int x = 0; x < 5; x++) {
            if (colour[x] == 1) count++;
        }
        return count == numOfDifferentTokens;
    }

    public boolean isGameOver() {
        for (int x = 0; x < this.players.length; x++) {
            if (this.players[x].cards[5] >= 15)
                return true;
        }
        return false;
    }
}
