package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;
import org.pmw.tinylog.writers.FileWriter;

import cards.Card;
import cards.Deck;
import evaluation.RankEvaluator;
import gamemechanics.GameMech;
import writer.CsvWriter;

public class Main {

    private static final int NUM_OF_ITERATIONS = 1;

    public static void logging() {
        Configurator.defaultConfig().formatPattern("{level} {date}: {class}@{line}\t:\t{method}()\t{message}")
                .writer(new FileWriter("log.txt")).level(Level.INFO).activate();
    }

    public static void main(String[] args) {
        /*File file = new File("evals.csv");
        if (file.exists()) {
            file.delete();
        }
        // RankEvaluator eval = new RankEvaluator();
        long currentTimeStamp;
        System.out.println("new deck created!");
        for (int i = 0; i < NUM_OF_ITERATIONS; i++) {
            Deck deck = new Deck();
            currentTimeStamp = System.currentTimeMillis();
            List<Card> hand = new ArrayList<>();
            hand.add(deck.deal());
            hand.add(deck.deal());
            List<Card> desk = new ArrayList<>();
            Random rand = new Random();
            int cardsNum = rand.nextInt(3) + 3;
            for (int c = 0; c < cardsNum; c++) {
                desk.add(deck.deal());
            }
            CsvWriter.writeCsv(hand, desk, new RankEvaluator().rank(hand, desk), file.getPath(), System.currentTimeMillis() - currentTimeStamp);
        }*/
        GameMech gm = new GameMech();
        gm.runGame();
    }
}