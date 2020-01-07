package evaluation.impl;

import java.util.List;

import org.pmw.tinylog.Logger;

import cards.Card;
import cards.CardSuit;
import evaluation.RankValueCalculator;

public class Flush extends RankValueCalculator {

    public Flush() {
        super();
    }

    @Override
    protected boolean evaluate(List<Card> cards) {
        int listSize = cards.size();
        this.sortHand(cards);
        int clubsNum = 0;
        int diamondsNum = 0;
        int heartsNum = 0;
        int spadesNum = 0;
        for (int i = 0; i < listSize; i++) {
            if (cards.get(i).getSuit().equals(CardSuit.CLUBS)) {
                clubsNum++;
                if (clubsNum == 5) {
                    break;
                } else {
                    continue;
                }
            } else if (cards.get(i).getSuit().equals(CardSuit.DIAMONDS)) {
                diamondsNum++;
                if (diamondsNum == 5) {
                    break;
                } else {
                    continue;
                }
            } else if (cards.get(i).getSuit().equals(CardSuit.HEARTS)) {
                heartsNum++;
                if (heartsNum == 5) {
                    break;
                } else {
                    continue;
                }
            } else {
                spadesNum++;
                if (spadesNum == 5) {
                    break;
                } else {
                    continue;
                }
            }
        }
        if (clubsNum == 5 || diamondsNum == 5 || heartsNum == 5 || spadesNum == 5) {
            Logger.info("Flush active");
            return true;
        } else {
            return false;
        }
    }
}