package evaluation.impl;

import java.util.List;

import cards.Card;
import evaluation.RankValueCalculator;

public class HighCard extends RankValueCalculator {
    
    public HighCard() {
        super();
    }
    
    @Override
    protected boolean evaluate(List<Card> list) {
        return true;
    }
}