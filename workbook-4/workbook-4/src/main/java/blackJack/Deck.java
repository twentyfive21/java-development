package blackJack;
import java.util.ArrayList;
import java.util.Collections;
class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // Create all the cards in the deck and add them to the ArrayList
        for (String suit : suits) {
            for (String value : values) {
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        // Deal the top card (if there are any cards left)
        if (cards.size() > 0) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

    public int getSize() {
        return cards.size();
    }
}