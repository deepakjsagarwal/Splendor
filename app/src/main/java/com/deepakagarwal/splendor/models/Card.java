package com.deepakagarwal.splendor.models;

public class Card {

    public String colour;
    public int[] price; //pinkPrice,bluePrice,greenPrice,redPrice,blackPrice,
    public int victoryPoints;

    public int idNumber;
    int level;

    public Card(String colour, int[] price, int victoryPoints, int idNumber, int level) {
        this.colour = colour;
        this.price = price;
        this.victoryPoints = victoryPoints;
        this.idNumber = idNumber;
        this.level = level;
    }
}
