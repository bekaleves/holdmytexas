package cards;

public enum CardSuit {
    CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);
    private int color;

    private CardSuit(int color) {
        this.color = color;
    }

    public int getSuit() {
        return color;
    }
}
