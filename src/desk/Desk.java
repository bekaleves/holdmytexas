package desk;

import java.util.List;

import cards.Card;

public class Desk {

    private int pot;
    private int playerNum;
    private List<Card> cardsOnDesk;
    private int callAmount;
    
    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int amount) {
        this.pot += amount;
    }

    public List<Card> getCardsOnDesk() {
        return cardsOnDesk;
    }

    public void setCardsOnDesk(List<Card> cardsOnDesk) {
        this.cardsOnDesk = cardsOnDesk;
    }

    public int getCallAmount() {
        return callAmount;
    }

    public void setCallAmount(int callAmount) {
        this.callAmount = callAmount;
    }
}
