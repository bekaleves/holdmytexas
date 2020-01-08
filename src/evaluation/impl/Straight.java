package evaluation.impl;

import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;

import cards.Card;
import evaluation.RankValueCalculator;

public class Straight extends RankValueCalculator {

    public Straight() {
        super();
    }

    @Override
    protected boolean evaluate(List<Card> cards) {

        List<Card> hand = new ArrayList<>();
        List<Card> tempCards = new ArrayList<>();
        tempCards.addAll(cards.subList(0, cards.size()));

        this.sortHand(tempCards);
        
        ciklus: while (hand.size() != 5 || tempCards.size() > 5) {
            for (int i = 0; i < tempCards.size() - 1; i++) {
                if (hand.size() == 0) {
                    if (tempCards.get(i).getCrdPwr().getPwr() == tempCards.get(i + 1).getCrdPwr().getPwr() + 1) {
                        hand.add(tempCards.get(i));
                    }
                } else if (hand.size() != 0 && i < tempCards.size() - 2) {
                    if (tempCards.get(i).getCrdPwr().getPwr() == hand.get(hand.size() - 1).getCrdPwr().getPwr() - 1) {
                        hand.add(tempCards.get(i));
                        if (hand.size() == 5) {
                            break ciklus;
                        }
                    }
                } else if ((hand.size() != 0) && (i == tempCards.size() - 2)) {
                    if ((tempCards.get(i).getCrdPwr().getPwr() == hand.get(hand.size() - 1).getCrdPwr().getPwr() - 1)) {
                        hand.add(tempCards.get(i));
                        if (hand.size() == 4) {
                            if ((tempCards.get(i).getCrdPwr().getPwr() == tempCards.get(i + 1).getCrdPwr().getPwr() + 1) ) {
                                hand.add(tempCards.get(i + 1));
                                return true;
                            }
                        }
                    }
                }
            }
            if (hand.size() < 5 && tempCards.size() > 5) {
                tempCards.remove(0);
                hand.clear();

            } else {
                break ciklus;
            }
        }
        if (hand.size() != 5) {
            Logger.info("Straight active");
            return false;
        } else {
            return true;
        }
    }
}