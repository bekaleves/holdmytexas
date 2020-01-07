package desk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cards.Card;
import cards.Deck;
import player.Player;

public class Dealer {
    
    private List<Card> flop = new ArrayList<>();
    private List<Card> inHand;
    private Card turnCard;
    private Card riverCard;
    private Scanner sc = new Scanner(System.in);
    
    public List<Card> startHand(Deck deck, Player player) {
        inHand = new ArrayList<>();
        while (true) {
            player.inHand.add(deck.deal());
            player.inHand.add(deck.deal());
            break;
        }
        return inHand;
    }
    
    public List<Card> flop(Deck deck, Desk desk) {
        this.flop.add(deck.deal());
        this.flop.add(deck.deal());
        this.flop.add(deck.deal());
        desk.setCardsOnDesk(flop);
        return flop;
    }
    
    public List<Card> getFlop() {
        return flop;
    }
    
    public Card turn(Deck deck, Desk desk) {
        turnCard = deck.deal();
        desk.getCardsOnDesk().add(turnCard);
        return turnCard;
    }
    
    public Card getTurnCard() {
        return turnCard;
    }
    
    public Card river(Deck deck, Desk desk) {
        riverCard = deck.deal();
        desk.getCardsOnDesk().add(riverCard);
        return riverCard;
    }
    
    public Card getRiverCard() {
        return riverCard;
    }
    
    public void yourTurn(Player player, Desk desk) {
        String next;
        while (true) {
            System.out.println("\nPress C to CHECK/CALL, R to BET/RAISE!");
            next = sc.next();
            if (next.equalsIgnoreCase("r")) {
                System.out.println("Set amount of bet:\n");
                next = sc.next();
                player.bet(Integer.parseInt(next));
                System.out.println(desk.getPot());
                break;
            } else if (next.equalsIgnoreCase("c")) {
                player.call(desk);
                break;
            } else {
                System.out.println("Bad input!");
            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The flop: ").append(flop.toString()).append("\n");
        return sb.toString();
    }
}
