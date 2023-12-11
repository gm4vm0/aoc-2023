package aoc2023.day07;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.*;

public class PartOne {
    private static final String INPUT_FILE = "inputs/day07.txt";

    public static void main(String[] args) throws IOException {
        int result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static int process(String input) {
        String[] lines = input.split("\\n");
        List<int[]> hands = new ArrayList<>();
        Map<int[], Integer> bids = new HashMap<>();
        for (String line : lines) {
            String handAsString = line.split(" ")[0];
            int bid = Integer.parseInt(line.split(" ")[1]);
            int[] cards = Arrays.stream(handAsString.split(""))
                                .mapToInt(card ->
                                        switch (card) {
                                            case "A" -> 14;
                                            case "K" -> 13;
                                            case "Q" -> 12;
                                            case "J" -> 11;
                                            case "T" -> 10;
                                            default -> Integer.parseInt(card);
                                        }
                                ).toArray();
            hands.add(cards);
            bids.put(cards, bid);
        }
        
        hands.sort(PartOne::compareHands);

        int sum = 0;
        for (int i = 0; i < hands.size(); i++) {
            sum += (i + 1) * bids.get(hands.get(i));
        }
        return sum;
    }

    private static int compareHands(int[] handA, int[] handB) {
        int typeComparison = Type.of(handA).compareTo(Type.of(handB));
        if (typeComparison == 0) {
            for (int i = 0; i < 5; i++) {
                if (handA[i] != handB[i]) {
                    return handA[i] - handB[i];
                }
            }
        }
        return typeComparison;
    }

    private enum Type {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        FIVE_OF_A_KIND;

        private static Type of(int[] hand) {
            Map<Integer, Integer> cardCounts = new HashMap<>();
            for (int card : hand) {
                if (cardCounts.containsKey(card)) {
                    cardCounts.put(card, cardCounts.get(card) + 1);
                } else {
                    cardCounts.put(card, 1);
                }
            }

            if (cardCounts.containsValue(5)) {
                return FIVE_OF_A_KIND;
            }

            if (cardCounts.containsValue(4)) {
                return FOUR_OF_A_KIND;
            }

            if (cardCounts.containsValue(2) && cardCounts.containsValue(3)) {
                return FULL_HOUSE;
            }

            if (cardCounts.containsValue(3)) {
                return THREE_OF_A_KIND;
            }

            if (cardCounts.containsValue(2)) {
                if (Arrays.stream(hand).distinct().count() == 3) {
                    return TWO_PAIR;
                }
                return ONE_PAIR;
            }

            return HIGH_CARD;
        }
    }
}
