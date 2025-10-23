package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void deal(Card card) {
        this.cards.add(card);
    }

    public int getSize() {
        return this.cards.size();
    }

    public int getValue() {
        int valueOfCard = 0;

        for (Card card: cards) {
            card.flip();
            valueOfCard += card.getPointValue();
        }

        return valueOfCard;
    }
}
