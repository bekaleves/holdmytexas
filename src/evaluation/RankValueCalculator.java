package evaluation;

import java.util.List;

import cards.Card;

public abstract class RankValueCalculator {
    
    private HandsPowerRank value;

    public HandsPowerRank getValue() {
        return value;
    }

    protected abstract boolean evaluate(List<Card> list);

    protected void sortHand(List<Card> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                int result = list.get(j).compareTo(list.get(j + 1));
                if (result >= 0) {
                    continue;
                }
                if (result < 0) {
                    Card temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
