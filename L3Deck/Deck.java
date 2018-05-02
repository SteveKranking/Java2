import java.util.Random;
import java.util.ArrayList;

public class Deck {

    String[] suits = {
        "Clubs", "Diamonds", "Hearts", "Spades"
    };

    String[] ranks = {
        "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King", "Ace"
    };

    private int numCards = 52;

    public int[] deck = new int[52]; 

    public void shuffle() {
        for (int i = 0; i < numCards; i++) {
            int r = i + (int) (Math.random() * (numCards-i));
            int temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
    }

    public void showShuffle() {
        for (int i = 0; i < numCards; i++) {
            System.out.println(deck[i]);
        }
    }

    public void createDeck() {
        for (int i = 0; i < deck.length; i++) {
           deck[i] = i;
        }
    }

    public void deal() {
        if (deck.length == 0) {
            System.out.println("There are no more cards in the deck");
        }
        int pos = deck.length - numCards;
        String suit = suits[deck[pos]/ 13];
        String rank = ranks[deck[pos]% 13];
        System.out.println("Your card is " + rank +" of " + suit);

        numCards-=1;
    }
}