package com.pluralsight;

public class Card {
    private String suit, label;
    private boolean isFaceUp;

    public Card(String suit, String label) {
        this.suit = suit;
        this.label = label;
        this.isFaceUp = false;
    }
     private String getSuit() {
        if (isFaceUp) {
            return this.suit;
        } else {
            return "???";
        }
     }

     public String getLabel() {
        if (isFaceUp) {
            return this.suit;
        } else {
            return "???";
        }
     }

     public int getPointValue() {
        if (isFaceUp) {
            switch (this.label) {
                case "K" ,"Q" ,"J":
                    return 10;
                case "A":
                    return 11;
                default:
                    return Integer.parseInt(this.label);
            }
        } else {
            return 0;
        }
     }

     public boolean isFaceUp() {
        return this.isFaceUp;
     }

     public void flip() {
        this.isFaceUp = !this.isFaceUp;
     }
}
