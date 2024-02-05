/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Maharshi Patel
 *         Student Number: 991714868
 */
public class CardTrick {

    public static void main(String[] args) {

        // Create an array to represent the hand of seven cards
        Card[] magicHand = new Card[7];

        // Fill magicHand with random Card objects
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomNumber());
            c.setSuit(Card.SUITS[generateRandomNumber(0, 3)]);
            magicHand[i] = c;
        }

        // Ask the user for a card
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a card value (1-13) : ");
        int userValue = scanner.nextInt();
        System.out.print("Enter a suit (0-3 where 0-Hearts, 1-Diamonds, 2-Clubs, 3-Spades) : ");
        int userSuit = scanner.nextInt();

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit]);

        // Search magicHand for a match
        boolean matchFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                matchFound = true;
                break;
            }
        }

        // Report the result
        if (matchFound) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }

    // Helper method to generate a random number between 1 and 13
    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(13) + 1;
    }

    // Helper method to generate a random number within a specified range
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
