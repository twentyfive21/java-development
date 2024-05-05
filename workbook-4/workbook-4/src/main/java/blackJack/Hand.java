package blackJack;

import java.util.ArrayList;

class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    // Deal a card to the hand
    public void deal(Card card) {
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    public int getValue() {
        int value = 0;
        int aceCount = 0;
        for (Card card : cards) {
            card.flip(); // Turn the card face up
            int cardValue = card.getPointValue();
            if (cardValue == 11) {
                aceCount++;
            }
            value += cardValue;
            card.flip(); // Turn the card face down again
        }

        // Adjust Aces to be worth 1 if the total exceeds 21
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount = 0;
        }

        return value;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}

