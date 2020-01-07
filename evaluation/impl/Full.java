package evaluation.impl;

import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;

import cards.Card;
import evaluation.RankValueCalculator;

public class Full extends RankValueCalculator {

    public Full() {
        super();
    }

    @Override
    protected boolean evaluate(List<Card> l) {
        List<Card> temp = new ArrayList<>();
        int listSize = l.size();
        this.sortHand(l);
        for (int i = 0; i < listSize - 2; i++) {
            if (l.get(i).getCrdPwr().getPwr() == l.get(i + 1).getCrdPwr().getPwr()) {
                if (l.get(i + 1).getCrdPwr().getPwr() == l.get(i + 2).getCrdPwr().getPwr()) {
                    temp.add(l.get(i));
                    temp.add(l.get(i + 1));
                    temp.add(l.get(i + 2));
                }
            }
        }
        if (!(temp.isEmpty())) {
            for (int j = 0; j < listSize - 1; j++) {
                if ((l.get(j).getCrdPwr().getPwr() == l.get(j + 1).getCrdPwr().getPwr())
                        && (l.get(j).getCrdPwr().getPwr() != temp.get(1).getCrdPwr().getPwr())) {
                    Logger.info("Full House active");
                    return true;
                }
            }
        }
        return false;
    }
}