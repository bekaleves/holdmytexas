package gamemechanics;

import cards.Deck;
import desk.Dealer;
import desk.Desk;
import evaluation.HandsPowerRank;
import evaluation.RankEvaluator;
import player.ComputerPlayer;
import player.HumanPlayer;
import render.Render;

public class GameMech {
    
    public void runGame() {

        boolean play = true;
        RankEvaluator eval = new RankEvaluator();
        Dealer dealer = new Dealer(); // creating dealer
        Deck dealerDeck = new Deck(); // creating deck
        Desk desk = new Desk(); // creating a desk
        Render render = new Render();
        HumanPlayer hp = new HumanPlayer(dealerDeck, desk, "User1");
        desk.setPlayerNum(desk.getPlayerNum() + 1);
        HumanPlayer cp1 = new HumanPlayer(dealerDeck, desk, "User2");
        desk.setPlayerNum(desk.getPlayerNum() + 1);
        hp.setInPlay(true);
        cp1.setInPlay(true);
        while (play) {
            hp.setSmallBlind(true);
            hp.postSmallBlind();
            System.out.println(render.blindPost(hp));
            cp1.setBigBlind(true);
            cp1.postBigBlind();
            System.out.println(render.blindPost(cp1));
            dealer.startHand(dealerDeck, hp);
            dealer.startHand(dealerDeck, cp1);
            System.out.println(render.humanPlayer(cp1));
            System.out.println(render.humanPlayer(hp));
            dealer.yourTurn(hp, desk);
            dealer.flop(dealerDeck, desk);
            System.out.println(render.flop(dealer));
            System.out.println("evaluating flop\n");
            HandsPowerRank rank2 = eval.rank(cp1.getInHand(), dealer.getFlop());
            System.out.println(cp1.getName() + " has a " + rank2 + "\n");
            HandsPowerRank rank1 = eval.rank(hp.getInHand(), dealer.getFlop());
            System.out.println(hp.getName() + " has a " + rank1);
            dealer.yourTurn(hp, desk);
            dealer.turn(dealerDeck, desk);
            System.out.println(render.turn(dealer, dealer.getTurnCard()));
            System.out.println("evaluating turn");
            rank2 = eval.rank(cp1.getInHand(), dealer.getFlop(), dealer.getTurnCard());
            System.out.println(cp1.getName() + " has a " + rank2 + "\n");
            rank1 = eval.rank(hp.getInHand(), dealer.getFlop(), dealer.getTurnCard());
            System.out.println(hp.getName() + " has a " + rank1);
            dealer.yourTurn(hp, desk);
            dealer.river(dealerDeck, desk);
            System.out.println(render.river(dealer, dealer.getRiverCard()));
            System.out.println("evaluating river");
            rank2 = eval.rank(cp1.getInHand(), dealer.getFlop(), dealer.getTurnCard(), dealer.getRiverCard());
            System.out.println(cp1.getName() + " has a " + rank2 + "\n");
            rank1 = eval.rank(hp.getInHand(), dealer.getFlop(), dealer.getTurnCard(), dealer.getRiverCard());
            System.out.println(hp.getName() + " has a " + rank1);
            System.out.println("\nThe pot is " + desk.getPot() + "$!!\n");
            if (rank1.compareTo(rank2) == -1) {
                System.out.println(cp1.getName() + " wins!");
                cp1.setChips(desk.getPot());
                System.out.println(cp1.getName() + "'s chips: " + cp1.getChips() + "$");
            } else if (rank1.compareTo(rank2) == 1) {
                System.out.println(hp.getName() + " wins!");
                hp.setChips(desk.getPot());
                System.out.println(hp.getName() + "'s chips: " + hp.getChips() + "$");
            } else {
                System.out.println("It's a tie. NO TIEBREAKING!");
            }
            play = false;
        }
    }
}
