package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    public List<Card> deck;
    
    public Deck() {
        deck = new ArrayList<>();
        generateDeck();
        shuffleDeck();
    }

    private void generateDeck() {
        for (int i = 0; i < CardSuit.values().length; i++) {
            for (int j = 0; j < CardPower.values().length; j++) {
                deck.add(new Card(CardSuit.values()[i], CardPower.values()[j]));
            }
        }
    }
    
    private void shuffleDeck() {
        Collections.shuffle(deck);
    }
    
    public Card deal() {
        Card dealedCard = deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);
        return dealedCard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (Card card : deck) {
            sb.append(card);
            if (count % 8 != 0 && count != deck.size()) {
                sb.append(", ");
            } else {
                sb.append("\n");
            }
            count++;
        }
        sb.append("\n").append("Number of cards: ").append(count-1).append("\n");
        return sb.toString();
    }

    public int size() {
        return this.size();
    }

    public Card get(int i) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
