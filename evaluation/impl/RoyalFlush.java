package evaluation.impl;

import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;

import cards.Card;
import cards.CardPower;
import cards.CardSuit;
import evaluation.RankValueCalculator;

public class RoyalFlush extends RankValueCalculator {

    public RoyalFlush() {
        super();
    }

    @Override
    protected boolean evaluate(List<Card> cards) {
        int listSize = cards.size();
        this.sortHand(cards);
        List<Card> clubs = new ArrayList<>();
        List<Card> diamonds = new ArrayList<>();
        List<Card> hearts = new ArrayList<>();
        List<Card> spades = new ArrayList<>();
        List<Card> fiveCards = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            if (cards.get(i).getSuit().equals(CardSuit.CLUBS)) {
                clubs.add(cards.get(i));
                if (clubs.size() == 5) {
                    fiveCards.addAll(clubs);
                    break;
                } else {
                    continue;
                }
            } else if (cards.get(i).getSuit().equals(CardSuit.DIAMONDS)) {
                diamonds.add(cards.get(i));
                if (diamonds.size() == 5) {
                    fiveCards.addAll(diamonds);
                    break;
                } else {
                    continue;
                }
            } else if (cards.get(i).getSuit().equals(CardSuit.HEARTS)) {
                hearts.add(cards.get(i));
                if (hearts.size() == 5) {
                    fiveCards.addAll(hearts);
                    break;
                } else {
                    continue;
                }
            } else {
                spades.add(cards.get(i));
                if (spades.size() == 5) {
                    fiveCards.addAll(spades);
                    break;
                } else {
                    continue;
                }
            }
        }
        this.sortHand(fiveCards);
        int size = fiveCards.size();
        for (int i = 0; i < size - 1; i++) {
            if ((fiveCards.get(i).getCrdPwr().getPwr() - 1) == fiveCards.get(i + 1).getCrdPwr().getPwr()) {
                if (fiveCards.get(0).getCrdPwr().equals(CardPower.ACE)) {
                    if (i == size - 2) {
                        Logger.info("RoyalFlush active");
                        return true;
                    }
                } else {
                    return false;
                }
                continue;
            } else {
                return false;
            }
        }
        return false;
    }
}