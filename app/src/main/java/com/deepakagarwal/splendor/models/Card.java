package com.deepakagarwal.splendor.models;

public class Card {

    public String colour;
    public int[] priceWithVP; //pinkPrice,bluePrice,greenPrice,redPrice,blackPrice,victoryPoints

    public int idNumber;

    public Card(String colour, int[] priceWithVP, int idNumber) {
        this.colour = colour;
        this.priceWithVP = priceWithVP;
        this.idNumber = idNumber;
    }
}
