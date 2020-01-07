package player;


import cards.Deck;
import desk.Desk;

public class ComputerPlayer extends Player {

    public ComputerPlayer(Deck deck, Desk desk, String name) {
        super(deck, desk, name);
    }

    @Override
    public boolean isInPlay() {
        // TODO Auto-generated method stub
        return super.isInPlay();
    }

    @Override
    public void setInPlay(boolean inPlay) {
        // TODO Auto-generated method stub
        super.setInPlay(inPlay);
    }

    @Override
    public int getChips() {
        // TODO Auto-generated method stub
        return super.getChips();
    }

    @Override
    public void postSmallBlind() {
        // TODO Auto-generated method stub
        super.postSmallBlind();
    }

    @Override
    public void postBigBlind() {
        // TODO Auto-generated method stub
        super.postBigBlind();
    }

    @Override
    protected void raise(int raiseAmount) {
        // TODO Auto-generated method stub
        super.raise(raiseAmount);
    }

    @Override
    public boolean isDealer() {
        // TODO Auto-generated method stub
        return super.isDealer();
    }

    @Override
    public boolean isSmallBlind() {
        // TODO Auto-generated method stub
        return super.isSmallBlind();
    }

    @Override
    public boolean isBigBlind() {
        // TODO Auto-generated method stub
        return super.isBigBlind();
    }
}
