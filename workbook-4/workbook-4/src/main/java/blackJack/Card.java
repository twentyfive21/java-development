package blackJack;

class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit() {
        // Only return the suit if the card is face up
        if (isFaceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        // Only return the value if the card is face up
        if (isFaceUp) {
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        if (isFaceUp) {
            switch (value) {
                case "A":
                    return 11; // Ace is initially worth 11 points
                case "K":
                case "Q":
                case "J":
                    return 10; // Face cards are worth 10 points
                default:
                    // Numeric cards are worth their face value
                    return Integer.parseInt(value);
            }
        } else {
            return 0; // Face-down card has no value
        }
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}