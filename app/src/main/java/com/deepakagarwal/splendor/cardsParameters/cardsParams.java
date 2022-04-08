package com.deepakagarwal.splendor.cardsParameters;

public class cardsParams {

    public String colour;
    public int[] priceWithVP; //pinkPrice,bluePrice,greenPrice,redPrice,blackPrice,victoryPoints

    public int idNumber;

    public cardsParams(String colour, int[] priceWithVP,int idNumber) {
        this.colour = colour;
        this.priceWithVP = priceWithVP;
        this.idNumber = idNumber;
    }
}
