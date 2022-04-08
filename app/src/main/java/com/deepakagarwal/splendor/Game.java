package com.deepakagarwal.splendor;

public class Game {
    int currentPlayer = 0;
    int numOfPlayers;
    int[][][] playerTable;
    String[] playerName;
    static int totalTokens;

    public static boolean allDifferentToken(int[] colour,int numOfDifferentTokens){
        int count = 0;
        for(int x =0;x<5;x++){
            if(colour[x] == 1) count++;
        }
        return count == numOfDifferentTokens;
    }



}


