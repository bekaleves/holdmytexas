package evaluation.impl;

import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;

import cards.Card;
import evaluation.RankValueCalculator;

public class DoublePair extends RankValueCalculator {

    public DoublePair() {
        super();
    }

    @Override
    protected boolean evaluate(List<Card> l) {
        List<Card> temp = new ArrayList<>();
        int listSize = l.size();
        this.sortHand(l);
        for (int i = 0; i < listSize - 1; i++) {
            if ((l.get(i).getCrdPwr().getPwr() == l.get(i + 1).getCrdPwr().getPwr())) {
                temp.add(l.get(i));
                temp.add(l.get(i + 1));
            }
        }
        if (temp.size() > 2) {
            Logger.info("DoublePair active");
            return true;
        }
        return false;
    }
}
