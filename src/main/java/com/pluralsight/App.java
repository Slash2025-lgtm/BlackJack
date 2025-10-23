package com.pluralsight;

import java.util.Scanner;

public class App {
    public static String player1Name = "";
    public static String player2Name = "";

    public static int player1Hand = 0;
    public static int player2Hand = 0;

    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        while (true) {
            nameEntries();
        }
    }

    public static void nameEntries() {
        System.out.print("Please enter the name of Player 1: ");
        player1Name = keyboard.nextLine();

        System.out.print("Please enter the name of Player 2: ");
        player2Name = keyboard.nextLine();

        String welcome = String.format("\nWelcome to Black Jack Arena %s and %s \nremember anything over 21 is an automatic lost", player1Name, player2Name);
        System.out.println(welcome);
        turnPhase();
    }

    public static void turnPhase() {
        System.out.println("\n=== Turn Phase ===");
        player1Hand();

    }
    public static void player1Hand() {
        Hand hand = new Hand();
        Deck deck = new Deck();
        System.out.println("It is currently " + player1Name + "'s turn");

        deck.shuffleDeck();
        for (int i = 0; i < 2; i++) {
            Card card = deck.deal();
            hand.deal(card);
        }

        player1Hand = hand.getValue();
        System.out.println(player1Name + "'s hand: " + player1Hand);

        boolean turnPhase = true;

        for (int i = 0; i < 1; i++) {
            Card card = deck.deal();
            hand.deal(card);
        }

        while (turnPhase) {

            actions();
            System.out.print("Please enter 1 of the options above: ");
            String selected = keyboard.nextLine().trim();

            switch (selected) {
                case "1":
                    player1Hand += hand.getValue();
                    System.out.println(player1Name + "'s Current Hand: " + player1Hand);
                    break;
                case "2":
                    player2Hand();
                    turnPhase = false;
                    break;
                default:
                    System.out.println(player1Name + " has entered either a not valid number number or character");
            }
        }
    }

    public static void player2Hand() {
        Hand hand = new Hand();
        Deck deck = new Deck();
        System.out.println("It is currently " + player2Name + "'s turn");
        deck.shuffleDeck();
        for (int i = 0; i < 2; i++) {
            Card card = deck.deal();
            hand.deal(card);
        }

        player2Hand = hand.getValue();
        System.out.println(player2Name + "'s hand: " + player2Hand);

        boolean turnPhase = true;

        for (int i = 0; i < 1; i++) {
            Card card = deck.deal();
            hand.deal(card);
        }

        while (turnPhase) {

            actions();
            System.out.print("Please enter 1 of the options above: ");
            String selected = keyboard.nextLine().trim();

            switch (selected) {
                case "1":
                    player2Hand += hand.getValue();
                    System.out.println(player2Name + "'s Current Hand: " + player2Hand);
                    break;
                case "2":
                    result();
                    turnPhase = false;
                    break;
                default:
                    System.out.println(player1Name + " has entered either a not valid number number or character");
            }
        }
    }
    public static void actions() {
        System.out.println("Turn Options");
        System.out.println("\t[1] Hit Me!");
        System.out.println("\t[2] I'll Stand");
    }

    public static void result() {
        String winningPlayer = "";
        int lowestNumb = 0;

        if ((21 - player1Hand) >= 0 && player1Hand < 21) {
            winningPlayer = player1Name;
            lowestNumb = 21 - player1Hand;

            if ((21 - player2Hand) < lowestNumb && player2Hand < 21) {
                winningPlayer = player2Name;

            } else if ((21 - player2Hand == lowestNumb)) {
                winningPlayer = player1Name + " and " + player2Name + "2 have same amount\n";
                rematchQuestion();

            } else if (player1Hand > 21) {
                winningPlayer = player2Name + "wins by default becuase " + player1Name + " has went over 21";
            }
        } else {
            winningPlayer = player2Name;
        }

        System.out.println("\n=== Result ===");
        System.out.println("\t" + player1Name + " has: " + player1Hand + "\n\t" + player2Name + " has: " + player2Hand + "\nThe winning Player is: " + winningPlayer);
        System.exit(0);
    }

    public static void rematchQuestion() {
        System.out.println("Rematch? (Y/N): ");
        String selected = keyboard.nextLine().trim().toUpperCase();
        switch (selected) {
            case "Y":
                System.out.println("Starting the rematch (Click Enter to continue...)");
                keyboard.nextLine();
                run();
            case "N":
                System.out.println("Game Closed");
                System.exit(0);
        }
    }
}
