package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Day4/input.txt");
        Scanner input = new Scanner(file);
        List<Card> cards = new ArrayList<Card>();
        while (input.hasNextLine()) {
            Card x = new Card(input.nextLine());
            cards.add(x);
        }

        // Part 1
        cards.stream().map(c -> c.cardPoints).reduce(Integer::sum).ifPresent(System.out::println);

        // Part 2
        var totalPile = new ArrayList<Card>();
        cards.forEach(c -> processCard(c, cards, totalPile));
        System.out.println(totalPile.size());
    }

    static void processCard(Card card, List<Card> originalCards, List<Card> pileOfCards) {
        pileOfCards.add(card);

        for (int i = card.cardNumber; i < card.myWinningNumbers.size() + card.cardNumber; i++) {
            processCard(originalCards.get(i), originalCards, pileOfCards);
        }
    }

    public static class Card {
        int cardNumber;
        List<Integer> winningNumbers;
        List<Integer> myNumbers;
        List<Integer> myWinningNumbers;
        int cardPoints = 0;

        public Card(String input) {
            String[] parts = input.split(":");
            this.cardNumber = Integer.parseInt(parts[0].trim().split("\\s+")[1]);

            String[] numbersGroups = parts[1].trim().split("\\|");
            
            winningNumbers = Arrays.stream(numbersGroups[0].trim().split("\\s+"))
                    .map(Integer::parseInt)
                    .toList();

            myNumbers = Arrays.stream(numbersGroups[1].trim().split("\\s+")).map(Integer::parseInt).toList();

            myWinningNumbers = myNumbers.stream().filter(winningNumbers::contains).toList();

            if (!myWinningNumbers.isEmpty()) {
                cardPoints = (int) Math.pow(2, myWinningNumbers.size() - 1);
            }
        }
    }
}