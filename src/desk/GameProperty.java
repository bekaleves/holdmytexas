package desk;

public class GameProperty {
    
    private int initChips = 100;
    private int bigBlind = 10;
    private int smallBlind = bigBlind/2;
    //final static private int MAX_COMPUTER_PLAYER = 5;
    
    public int getInitChips() {
        return initChips;
    }
    public void setInitChips(int initChips) {
        this.initChips = initChips;
    }
    public int getBigBlind() {
        return bigBlind;
    }
    public void setBigBlind(int bigBlind) {
        this.bigBlind = bigBlind;
    }
    public int getSmallBlind() {
        return smallBlind;
    }
}
