package com.pluralsight;

public class App {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand hand = new Hand();

        deck.shuffleDeck();
        for (int i = 0; i < 2; i++) {
            Card card = deck.deal();
            hand.deal(card);
        }
        int player1Hand = hand.getValue();

        deck.shuffleDeck();
        for (int i = 0; i < 2; i++) {
            Card card = deck.deal();
            hand.deal(card);
        }
        int player2Hand = hand.getValue();

        String winningPlayer = "";
        int lowestNumb = 0;

        if ((21 - player1Hand) >= 0) {
            winningPlayer = "Player 1";
            lowestNumb = 21 - player1Hand;
            if ((21 - player2Hand) < lowestNumb) {
                winningPlayer = "Player 2";
            } else if ((21 - player2Hand == lowestNumb)) {
                winningPlayer = "Player 1 and 2 have same amount";
            }
        }
        System.out.println("Player 1 has: " + player1Hand + "\nPlayer 2 has: " + player2Hand + "\nThe winning Player is: " + winningPlayer);
    }


}
