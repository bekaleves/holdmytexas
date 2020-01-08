package evaluation.impl;

import java.util.List;

import cards.Card;
import evaluation.RankValueCalculator;

public class Poker extends RankValueCalculator {

    public Poker() {
        super();
    }

    @Override
    protected boolean evaluate(List<Card> list) {
        int size = list.size();
        this.sortHand(list);
        for (int i = 0; i < size - 3; i++) {
            if ((list.get(i).getCrdPwr().getPwr() == list.get(i + 1).getCrdPwr().getPwr())) {
                if (list.get(i + 1).getCrdPwr().getPwr() == list.get(i + 2).getCrdPwr().getPwr()) {
                    if (list.get(i + 2).getCrdPwr().getPwr() == list.get(i + 3).getCrdPwr().getPwr()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}