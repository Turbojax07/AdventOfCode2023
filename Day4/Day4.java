package Day4;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {
    public static class Card {
        public int cardNum;
        public String[] winning;

        public Card(String card) {
            this.cardNum = Integer.parseInt(card.replace(":", "").split(" ")[1]) - 1;
            this.winning = card.split("]")[0].split(" ");
        }
    }

    public static void part1(Scanner input) {
        int totalScore = 0;
        while (input.hasNextLine()) {
            int cardScore = 0;
            String line = input.nextLine();

            line = line.substring(line.indexOf(":") + 2).trim();

            String[] winningNums = line.split("]")[0].split(" ");
            List<String> myNums = Arrays.asList(line.split("]")[1].split(" "));
            for (String s : winningNums) {
                if (s.equals("")) continue;
                if (myNums.indexOf(s) > -1 && cardScore == 0) {
                    cardScore = 1;
                    System.out.print(s + " ");
                } else if (myNums.indexOf(s) > -1 && cardScore > 0) {
                    cardScore *= 2;
                    System.out.print(s + " ");
                }
            }

            totalScore += cardScore;
        }
        System.out.println(totalScore);
    }

    public static void part2(Scanner input) {
        List<Card> cards = new ArrayList<Card>();
        while (input.hasNextLine()) {
            Card x = new Card(input.nextLine());
            cards.add(x);
        }

        ArrayList<Card> allCards = new ArrayList<Card>();
        cards.forEach((card) -> {
            processCard(card, cards, allCards);
        });

        /*
        int initSize = cards.size() - 1;
        for (int i = 0; i < cards.size(); i++) {
            String line = cards.get(i);

            line = line.substring(line.indexOf(":") + 2).trim();
            int winners = getNumWinners(line);
            for (int j = 0; j < winners; j++) {
                cards.add(cards.get(initSize + j));
            }
        }
        System.out.println(cards.size());
        */
    }

    public static void processCard(Card card, List<Card> originalCards, List<Card> pileOfCards) {
        pileOfCards.add(card);

        for (int i = card.cardNum; i < card.winning.length + card.cardNum; i++) {
            processCard(originalCards.get(i), originalCards, pileOfCards);
        }
    }

    public static int getNumWinners(String card) {
        String[] winningNums = card.split("]")[0].split(" ");
        List<String> myNums = Arrays.asList(card.split("]")[1].split(" "));
        int score = 0;
        for (String s : winningNums) {
            if (s.equals("")) continue;
            if (myNums.indexOf(s) > -1) {
                score++;
            }
        }
        return score;
    }
}