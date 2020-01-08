package evaluation;

import org.pmw.tinylog.Logger;

import evaluation.impl.DoublePair;
import evaluation.impl.Drill;
import evaluation.impl.Flush;
import evaluation.impl.Full;
import evaluation.impl.HighCard;
import evaluation.impl.Pair;
import evaluation.impl.Poker;
import evaluation.impl.RoyalFlush;
import evaluation.impl.Straight;
import evaluation.impl.StraightFlush;

public class AlgorythmFactory {
    
    public static RankValueCalculator build(HandsPowerRank x) {
        switch (x) {
        case HIGHCARD:
            return new HighCard();
        case PAIR:
            return new Pair();
        case DOUBLEPAIR:
            return new DoublePair();
        case DRILL:
            return new Drill();
        case STRAIGHT:
            return new Straight();
        case FLUSH:
            return new Flush();
        case FULL:
            return new Full();
        case POKER:
            return new Poker();
        case STRAIGHTFLUSH:
            return new StraightFlush();
        case ROYALFLUSH:
            return new RoyalFlush();
        default:
            Logger.info("factory lefutott");
            return null;
        }
    }
}
