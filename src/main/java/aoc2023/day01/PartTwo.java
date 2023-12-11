package aoc2023.day01;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.Arrays;

public class PartTwo {
    private static final String INPUT_FILE = "inputs/day01.txt";

    public static void main(String[] args) throws IOException {
        int result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static int process(String input) {
        String[] inputs = input.split("\\n");
        return Arrays.stream(inputs)
                     .mapToInt(PartTwo::processLine)
                     .sum();
    }

    private static int processLine(String input) {
        int firstDigit = findDigit(input, 0);
        int secondDigit = findDigit(input, input.length() - 1);

        return firstDigit * 10 + secondDigit;
    }

    private static int findDigit(String input, int startingIndex) {
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int index = startingIndex;

        while (true) {
            for (int i = 0; i < words.length; i++) {
                if (input.substring(index).startsWith(words[i])) {
                    return i + 1;
                }
            }

            char character = input.charAt(index);
            if (Character.isDigit(character)) {
                return Character.getNumericValue(character);
            }

            index += (startingIndex == 0) ? 1 : -1;
        }
    }
}
