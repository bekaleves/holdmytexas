package cards;

public class Card implements Comparable<Card> {
    private CardSuit suit;
    private CardPower cardPower;

    public Card(CardSuit suit, CardPower power) {
        this.suit = suit;
        this.cardPower = power;
    }

    public CardPower getCrdPwr() {
        return cardPower;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cardPower).append(" of ").append(suit);
        return sb.toString();
    }

    @Override
    public int compareTo(Card card) {
        Integer card1Power = this.cardPower.getPwr();
        Integer card2Power = card.cardPower.getPwr();
        int powerComp = card1Power.compareTo(card2Power);
        Integer card1Suit = this.suit.getSuit();
        Integer card2Suit = card.suit.getSuit();
        int colComp = card1Suit.compareTo(card2Suit);
        //if (colComp == 0) {
        if (powerComp == 0) {
            return colComp;
            //return powerComp;
        }
        return powerComp;
        //return colComp;
    }

    public CardSuit getSuit() {
        return suit;
    }
}

