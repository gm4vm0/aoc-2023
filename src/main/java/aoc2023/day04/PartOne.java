package aoc2023.day04;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PartOne {
    private static final String INPUT_FILE = "inputs/day-four.txt";

    public static void main(String[] args) throws IOException {
        int result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static int process(String input) {
        String[] inputs = input.split("\\n");
        return Arrays.stream(inputs).mapToInt(PartOne::processLine).sum();
    }

    public static int processLine(String input) {
        input = input.replaceAll(".*: ", "");
        String[] parts = input.split("\\|");

        List<Integer> winningNumbers = Arrays.stream(parts[0].trim().split(" +")).map(Integer::parseInt).toList();
        List<Integer> ownNumbers = Arrays.stream(parts[1].trim().split(" +")).map(Integer::parseInt).toList();

        int score = 1;

        for (int number : ownNumbers) {
            if (winningNumbers.contains(number)) {
                score *= 2;
            }
        }

        return score == 1 ? 0 : score / 2;
    }
}
