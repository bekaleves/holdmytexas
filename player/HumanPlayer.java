package player;

import java.util.List;
import cards.Card;
import cards.Deck;
import desk.Desk;

public class HumanPlayer extends Player {
    
    public HumanPlayer(Deck deck, Desk desk, String name) {
        super(deck, desk, name);
    }

    @Override
    public void postSmallBlind() {
        super.postSmallBlind();
    }

    @Override
    public boolean isInPlay() {
        return super.isInPlay();
    }

    @Override
    public void setInPlay(boolean inPlay) {
        super.setInPlay(inPlay);
    }

    @Override
    public int getChips() {
        return super.getChips();
    }

    @Override
    public boolean isDealer() {
        return super.isDealer();
    }

    @Override
    public void setDealer(boolean isDealer) {
        super.setDealer(isDealer);
    }

    @Override
    public boolean isSmallBlind() {
        return super.isSmallBlind();
    }

    @Override
    public void setSmallBlind(boolean isSmallBlind) {
        super.setSmallBlind(isSmallBlind);
    }

    @Override
    public boolean isBigBlind() {
        return super.isBigBlind();
    }

    @Override
    public void setBigBlind(boolean isBigBlind) {
        super.setBigBlind(isBigBlind);
    }

    @Override
    public List<Card> getInHand() {
        return super.getInHand();
    }
}
