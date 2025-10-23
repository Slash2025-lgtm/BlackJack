package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts","Spades","Diamonds","Clubs"};
        String[] labels = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for(String suit: suits){
            for(String value: labels){
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }

    public void  shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (cards.size() > 0) {
            Card card = cards.remove(0);
            return card;
        } else {
            return null;
        }
    }

    public int getSize() {
        return cards.size();
    }
}
