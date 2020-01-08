package player;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.Deck;
import desk.Desk;
import desk.GameProperty;

public abstract class Player {

    public List<Card> inHand = new ArrayList<>();
    protected Desk desk;
    private int chips;
    private String name;
    private GameProperty properties = new GameProperty();
    private boolean isDealer;
    private boolean isSmallBlind;
    private boolean isBigBlind;
    private boolean inPlay;
    
    public Player(Deck deck, Desk desk, String name) {
        inHand = new ArrayList<>();
        this.chips = properties.getInitChips();
        this.desk = desk;
        this.name = name;
    }
    
    public List<Card> getInHand() {
        return inHand;
    }

    public boolean isInPlay() {
        return inPlay;
    }

    public void setInPlay(boolean inPlay) {
        this.inPlay = inPlay;
    }

    public int getChips() {
        return chips;
    }
    
    protected void postSmallBlind() {
        this.chips -= properties.getSmallBlind();
        desk.setPot(properties.getSmallBlind());
    }
    
    public void postBigBlind() {
        this.chips -= properties.getBigBlind();
        desk.setPot(properties.getBigBlind());
    }
    
    public void bet(int betAmount) {
        if (betAmount >= properties.getBigBlind()) {
            this.chips -= betAmount;
            desk.setPot(betAmount);
        }
    }
    
    protected void raise(int raiseAmount) {
        if (raiseAmount >= properties.getBigBlind()) {
            this.chips -= raiseAmount;
            desk.setPot(raiseAmount);
        }
    }
    
    public boolean isDealer() {
        return isDealer;
    }

    public void setDealer(boolean isDealer) {
        this.isDealer = isDealer;
    }

    public boolean isSmallBlind() {
        return isSmallBlind;
    }

    public void setSmallBlind(boolean isSmallBlind) {
        this.isSmallBlind = isSmallBlind;
    }

    public boolean isBigBlind() {
        return isBigBlind;
    }

    public void setBigBlind(boolean isBigBlind) {
        this.isBigBlind = isBigBlind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void call(Desk desk) {
        this.chips -= desk.getCallAmount();
        desk.setPot(desk.getCallAmount());
    }

    public void setChips(int chips) {
        this.chips += chips;
    }
}