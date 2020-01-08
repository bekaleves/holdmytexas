package render;

import cards.Card;
import desk.Dealer;
import desk.Desk;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;

public class Render {
    
    
    public String renderDesk(Desk desk, Dealer dealer) {
        StringBuilder sb = new StringBuilder();
        sb.append("Number of computer players: ").append(desk.getPlayerNum()).append("\n");
        sb.append("Following cards are on the desk: ").append(dealer.toString()).append("\n");
        return sb.toString();
    }
    
    public String humanPlayer(HumanPlayer player) {
        StringBuilder sb = new StringBuilder();
        sb.append(player.getName() + " has: ").append(player.getInHand()).append("\n");
        sb.append(player.getName() + "'s chips: ").append(player.getChips()).append("\n");
        return sb.toString();
    }
    
    public String comPlayer(ComputerPlayer player) {
        StringBuilder sb = new StringBuilder();
        sb.append("Computer has: ").append("X").append("\n");
        sb.append("Computer chips: ").append(player.getChips());
        return sb.toString();
    }
    
    public String flop(Dealer dealer) {
        StringBuilder sb = new StringBuilder();
        sb.append("The flop, ").append(dealer.getFlop()).append(" is added to table").append("\n");
        sb.append("The cards on table: ").append(dealer.getFlop()).append("\n");
        return sb.toString();
    }
    
    public String turn(Dealer dealer, Card card) {
        StringBuilder sb = new StringBuilder();
        sb.append("The turn, ").append(dealer.getTurnCard()).append(" is added to table").append("\n");
        sb.append("The cards on table: ").append(dealer.getFlop()).append("\n");
        return sb.toString();
    }
    
    public String river(Dealer dealer, Card card) {
        StringBuilder sb = new StringBuilder();
        sb.append("The river, ").append(dealer.getRiverCard()).append(" is added to table").append("\n");
        sb.append("The cards on table: ").append(dealer.getFlop()).append("\n");
        return sb.toString();
    }
    
    public String blindPost(Player player) {
        StringBuilder sb = new StringBuilder();
        if (player.isSmallBlind()) {
            sb.append(player.getName()).append(" ").append("added small blind").append(System.lineSeparator());
        }
        if (player.isBigBlind()) {
            sb.append(player.getName()).append(" ").append("added big blind").append(System.lineSeparator());
        }
        return sb.toString();
    }
}
