package aoc2023.day04;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartTwo {
    private static final String INPUT_FILE = "inputs/day-four.txt";

    public static void main(String[] args) throws IOException {
        int result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static int process(String input) {
        Map<Integer, Integer> copies = new HashMap<>();

        String[] inputs = input.split("\\n");

        Arrays.stream(inputs).forEach((line) -> {
            int cardNumber = Integer.parseInt(line.split("\\s+|:")[1]);
            line = line.replaceAll(".*: ", "");
            String[] game = line.split("\\|");

            int count = countWinningNumbers(game);

            if (!copies.containsKey(cardNumber)) {
                copies.put(cardNumber, 0);
            }
            copies.put(cardNumber, copies.get(cardNumber) + 1);
            int currentCardCopies = copies.get(cardNumber);

            for (int i = 1; i <= count; i++) {
                int newCardNumber = cardNumber + i;
                if (!copies.containsKey(newCardNumber)) {
                    copies.put(newCardNumber, 0);
                }
                copies.put(newCardNumber, (copies.get(newCardNumber) + currentCardCopies));
            }
        });

        return copies.values().stream().mapToInt(Integer::valueOf).sum();
    }

    private static int countWinningNumbers(String[] parts) {
        List<Integer> winningNumbers = Arrays.stream(parts[0].trim().split(" +")).map(Integer::parseInt).toList();
        List<Integer> ownNumbers = Arrays.stream(parts[1].trim().split(" +")).map(Integer::parseInt).toList();

        int count = 0;

        for (int number : ownNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
