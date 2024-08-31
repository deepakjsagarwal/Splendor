package com.deepakagarwal.splendor.models;

import static com.deepakagarwal.splendor.AskNumberOfPlayers.game;
import static com.deepakagarwal.splendor.utils.Constants.COUNT_TABLE_LEVEL_CARD;
import static com.deepakagarwal.splendor.utils.Constants.COUNT_TABLE_NOBEL;
import static com.deepakagarwal.splendor.utils.Constants.LEVELS;
import static com.deepakagarwal.splendor.utils.Constants.LEVEL_1;
import static com.deepakagarwal.splendor.utils.Constants.LEVEL_2;
import static com.deepakagarwal.splendor.utils.Constants.LEVEL_3;
import static com.deepakagarwal.splendor.utils.Constants.NOBEL;
import static com.deepakagarwal.splendor.utils.Constants.intToColor;

public class Game {

    public Deck[] levelDeck;

    public int currentPlayer;
    public Player[] players;

    public Card[][] tableCard;
    public int[] tableTokens;

    public Game(int numOfPlayers) {
        players = new Player[numOfPlayers];

        for (int i = 0; i < numOfPlayers; i++) {
            players[i] = new Player();
        }

        levelDeck = new Deck[LEVELS];

        for (int i = 0; i < LEVELS; i++) {
            levelDeck[i] = new Deck(i);
        }

        tableCard = new Card[LEVELS][];
        tableCard[LEVEL_1] = new Card[COUNT_TABLE_LEVEL_CARD];
        tableCard[LEVEL_2] = new Card[COUNT_TABLE_LEVEL_CARD];
        tableCard[LEVEL_3] = new Card[COUNT_TABLE_LEVEL_CARD];
        tableCard[NOBEL] = new Card[COUNT_TABLE_NOBEL];

        for (int i = 0; i < LEVELS; i++) {
            for (int j = 0; j < tableCard[i].length; j++) {
                tableCard[i][j] = this.levelDeck[i].drawCard();
            }
        }

        if (this.players.length == 2) {
            tableTokens = new int[]{4, 4, 4, 4, 4};
        } else if (this.players.length == 3) {
            tableTokens = new int[]{6, 6, 6, 6, 6};
        } else if (this.players.length == 4) {
            tableTokens = new int[]{8, 8, 8, 8, 8};
        }

        currentPlayer = 0;
    }

    public boolean isGameOver() {
        for (int x = 0; x < this.players.length; x++) {
            if (this.players[x].victoryPoints >= 15)
                return true;
        }
        return false;
    }

    public Player getCurrentPlayer() {
        return this.players[currentPlayer];
    }

    public void changeCurrentPlayer() {
        this.currentPlayer = (++this.currentPlayer) % this.players.length;
    }

    public void pickTokens(int[] colourAdded) {
        this.getCurrentPlayer().pickTokens(colourAdded);

        for (int i = 0; i < tableTokens.length; i++) {
            tableTokens[i] -= colourAdded[i];
        }
    }

    public void purchaseCard(Card card) {
        int[] extraTokens = this.getCurrentPlayer().purchaseCard(card);
        for (int i = 0; i < tableTokens.length; i++) {
            tableTokens[i] += extraTokens[i];
        }
    }

    public void checkAndPurchaseNobel() {
        for (int x = 0; x < game.tableCard[NOBEL].length; x++) {
            if (this.getCurrentPlayer().canPurchaseCard(game.tableCard[NOBEL][x])) {
                game.getCurrentPlayer().addCardWithScore(game.tableCard[NOBEL][x]);
                game.tableCard[NOBEL][x] = game.levelDeck[NOBEL].back;
            }
        }
    }

    public String getWinner() {
        StringBuilder winnerName = new StringBuilder(this.players[0].name);
        int winner = 0;
        int maxScore = this.players[0].victoryPoints;

        for (int x = 1; x < this.players.length; x++) {
            if (maxScore == this.players[x].victoryPoints) {
                if (this.players[winner].getCountOfCards() > this.players[x].getCountOfCards()) {
                    winner = x;
                    maxScore = game.players[x].victoryPoints;
                    winnerName = new StringBuilder(game.players[x].name);
                } else if (this.players[winner].getCountOfCards() == this.players[x].getCountOfCards()) {
                    winnerName.append(", ").append(game.players[x].name);
                }
            } else if (maxScore < game.players[x].victoryPoints) {
                winner = x;
                maxScore = game.players[x].victoryPoints;
                winnerName = new StringBuilder(game.players[x].name);
            }
        }
        return winnerName.toString();
    }

    public String checkTokenAdded(int[] colourAdded) {

        int[] tID = this.tableTokens;
        for (int i = 0; i < colourAdded.length; i++) {
            if (colourAdded[i] > tID[i]) {
                return "Enough " + intToColor(i) + " Tokens are not available.";
            }
        }

        int addedTokens = 0;
        for (int i = 0; i < colourAdded.length; i++) {
            addedTokens += colourAdded[i];
        }
        if (addedTokens > 3) {
            return "You cannot pick more than 3 Tokens.";
        } else if (addedTokens <= 0) {
            return "Choose some tokens.";
        }

        switch (this.getCurrentPlayer().totalNumberOfTokens()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                switch (addedTokens) {
                    case 3:
                        if (allDifferentToken(colourAdded, 3)) {
                            return "";
                        } else {
                            return "You have to choose 3 Different Tokens.";
                        }
                    case 2:
                        if (twoSameToken(colourAdded, tID)) return "";
                        else if (allDifferentToken(colourAdded, 2) && numOfZeroToken(tID) == 3)
                            return "";
                        else {
                            return "You have to choose 2 Same tokens or 3 Different.";
                        }
                    case 1:
                        if (numOfZeroToken(tID) == 4 && oneTokenAdded(colourAdded, tID)) {
                            return "";
                        } else {
                            return "Try Again, You can pick more than 1 Token.";
                        }
                    default:
                        return "Not a possible scenario.";
                }
            case 8:
                switch (addedTokens) {
                    case 2:
                        if (allDifferentToken(colourAdded, 2)) return "";
                        else if (twoSameToken(colourAdded, tID)) return "";
                        else {
                            return "You can pick 2 Different or 2 Same only if there are 4 or more tokens available.";
                        }
                    case 1:
                        if (numOfZeroToken(tID) == 4 && oneTokenAdded(colourAdded, tID)) {
                            return "";
                        } else {
                            return "You can pick 2 Tokens.";
                        }
                    default:
                        return "You have 8 Tokens, you can not pick 3 Tokens.";
                }
            case 9:
                if (allDifferentToken(colourAdded, 1)) {
                    return "";
                } else {
                    return "You have 9 Tokens, you can not pick more than 1 Tokens.";
                }
            default:
                return "You have 10 Tokens, can't pick more.";
        }
    }

    public boolean allDifferentToken(int[] colour, int numOfDifferentTokens) {
        int count = 0;
        for (int x = 0; x < colour.length; x++) {
            if (colour[x] == 1) count++;
        }
        return count == numOfDifferentTokens;
    }

    public int numOfZeroToken(int[] colour) {
        int count = 0;
        for (int x = 0; x < colour.length; x++) {
            if (colour[x] == 0) count++;
        }
        return count;
    }

    public boolean twoSameToken(int[] colourAdded, int[] colourID) {
        if (allDifferentToken(colourAdded, 2))
            return false;
        else {
            for (int x = 0; x < colourAdded.length; x++) {
                if (colourAdded[x] == 2)
                    return colourID[x] >= 4;
            }
        }
        return false;
    }

    public boolean oneTokenAdded(int[] colourAdded, int[] colourID) {
        for (int x = 0; x < colourAdded.length; x++) {
            if (colourAdded[x] == 1)
                return colourID[x] < 4;
        }
        return false;
    }
}
