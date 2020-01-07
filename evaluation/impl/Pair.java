package evaluation.impl;

import java.util.List;

import org.pmw.tinylog.Logger;

import cards.Card;
import evaluation.RankValueCalculator;

public class Pair extends RankValueCalculator {

    public Pair() {
        super();
    }

    @Override
    protected boolean evaluate(List<Card> list) {
        int listSize = list.size();
        this.sortHand(list);
        for (int i = 0; i < listSize - 1; i++) {
            if ((list.get(i).getCrdPwr().getPwr() == list.get(i + 1).getCrdPwr().getPwr())) {
                Logger.info("Pair active");
                return true;
            }
        }
        return false;
    }
}
