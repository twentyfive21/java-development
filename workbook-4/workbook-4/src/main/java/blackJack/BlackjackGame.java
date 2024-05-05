package blackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame {
    private static ArrayList<Player> players = new ArrayList<>();
    private static Deck deck;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Prompt for player names and create Player objects
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the name of player " + (i + 1) + ": ");
            // get player name
            String playerName = scanner.nextLine();
            // create player object
            Player player = new Player(playerName);
            // add player object to players array list
            players.add(player);
        }

        // Create a new deck and shuffle it
        deck = new Deck();
        deck.shuffle();

        // Deal two cards to each player
        for (Player player : players) {
            // create a hand object
            Hand hand = new Hand();
            // give the player a empty hand arraylist
            player.setHand(hand);
            // set the hand with two cards
            // deck.deal returns a card object and hand.deal adds it to arraylist
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }

        // Allow players to hit or stay
        for (Player player : players) {
            // get the players hand of cards
            Hand hand = player.getHand();
            // set busted to false until true
            boolean playerBusted = false;
            while (!playerBusted) {
                System.out.println(player.getName() + "'s hand: " + hand.getCards());
                // find the current total
                System.out.println("Total: " + hand.getValue());
                System.out.print("Do you want to hit or stay? (h/s): ");
                String choice = scanner.nextLine();
                // if hit keep prompting until player busted
                if (choice.equalsIgnoreCase("h")) {
                    hand.deal(deck.deal());
                    int total = hand.getValue();
                    if (total > 21) {
                        playerBusted = true;
                        System.out.println(player.getName() + " busted!");
                    }
                    // stay and break out while loop !
                } else if (choice.equalsIgnoreCase("s")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 'h' or 's'.");
                }
            }
            // set the players total at the end after sllowing them to h/s
            int total = hand.getValue();
            player.setTotal(total);
        }

        // Determine the winner
        Player winner = null;
        int maxTotal = 0;
        for (Player player : players) {
            // check if players total is close to 21 or 21
            int total = player.getTotal();
            if (total <= 21 && total > maxTotal) {
                maxTotal = total;
                // set the winner
                winner = player;
            }
        }

        // Display each player's hand and the winner
        for (Player player : players) {
            Hand hand = player.getHand();
            System.out.println(player.getName() + "'s hand: " + hand.getCards());
            System.out.println("Total: " + player.getTotal());
        }

        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with a total of " + winner.getTotal());
        } else {
            System.out.println("No winner! All players busted.");
        }
    }
}