package evaluation;

import java.util.ArrayList;
import java.util.List;

import cards.Card;

public class RankEvaluator {

    private List<RankValueCalculator> algs = new ArrayList<>();
    private List<Card> evaluableHand = new ArrayList<>();
    
    public RankEvaluator() {
        putRanksIntoFactory();
    }
    
    public void putRanksIntoFactory() {
        for (HandsPowerRank powers : HandsPowerRank.values()) {
            algs.add(AlgorythmFactory.build(powers));
        }
    }

    public List<Card> getEvaluableHand() {
        return evaluableHand;
    }
    
    public HandsPowerRank rank(List<Card> playerHand) {
        evaluableHand.addAll(playerHand);
        System.out.println(playerHand);
        for (int i = algs.size() - 1; i >= 0; i--) {
            boolean temp = algs.get(i).evaluate(evaluableHand);
            if (temp == true) {
                evaluableHand.clear();
                return HandsPowerRank.values()[i];
            }
        }
        return null;
    }
    
    public HandsPowerRank rank(List<Card> playerHand, List<Card> desk) {
        evaluableHand.addAll(playerHand);
        evaluableHand.addAll(desk);
        for (int i = algs.size() - 1; i >= 0; i--) {
            boolean temp = algs.get(i).evaluate(evaluableHand);
            if (temp == true) {
                System.out.println(evaluableHand);
                evaluableHand.clear();
                return HandsPowerRank.values()[i];
            }
        }
        return null;
    }
    
    public HandsPowerRank rank(List<Card> playerHand, List<Card> desk, Card turn) {
        evaluableHand.addAll(playerHand);
        evaluableHand.addAll(desk);
        for (int i = algs.size() - 1; i >= 0; i--) {
            boolean temp = algs.get(i).evaluate(evaluableHand);
            if (temp == true) {
                System.out.println(evaluableHand);
                evaluableHand.clear();
                return HandsPowerRank.values()[i];
            }
        }
        return null;
    }
    
    public HandsPowerRank rank(List<Card> playerHand, List<Card> desk, Card turn, Card river) {
        evaluableHand.addAll(playerHand);
        evaluableHand.addAll(desk);
        for (int i = algs.size() - 1; i >= 0; i--) {
            boolean temp = algs.get(i).evaluate(evaluableHand);
            if (temp == true) {
                //System.out.println(HandsPowerRank.values()[i] + " recognized");
                System.out.println(evaluableHand);
                evaluableHand.clear();
                return HandsPowerRank.values()[i];
            }
        }
        return null;
    }
}
