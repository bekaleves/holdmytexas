package evaluation.impl;

import java.util.List;

import org.pmw.tinylog.Logger;

import cards.Card;
import evaluation.RankValueCalculator;

public class Drill extends RankValueCalculator {

    public Drill() {
        super();
    }

    @Override
    protected boolean evaluate(List<Card> list) {
        int size = list.size();
        this.sortHand(list);
        for (int i = 0; i < size - 2; i++) {
            if (list.get(i).getCrdPwr().getPwr() == list.get(i + 1).getCrdPwr().getPwr()) {
                if (list.get(i + 1).getCrdPwr().getPwr() == list.get(i + 2).getCrdPwr().getPwr()) {
                    Logger.info("Drill algo aktív");
                    return true;
                }
            }
        }
        return false;
    }
}
