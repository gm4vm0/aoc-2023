package aoc2023.dayone;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.Arrays;

public class PartOne {
    private static final String INPUT_FILE = "inputs/day-one.txt";

    public static void main(String[] args) throws IOException {
        int result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static int process(String input) {
        String[] inputs = input.split("\\n");
        return Arrays.stream(inputs)
                     .mapToInt(PartOne::processLine)
                     .sum();
    }

    private static int processLine(String input) {
        // find first digit
        int firstDigit;
        int index = 0;
        while (true) {
            char character = input.charAt(index);
            if (Character.isDigit(character)) {
                firstDigit = Character.getNumericValue(character);
                break;
            }
            index++;
        }

        // find second digit
        int secondDigit;
        index = input.length() - 1;
        while (true) {
            char character = input.charAt(index);
            if (Character.isDigit(character)) {
                secondDigit = Character.getNumericValue(character);
                break;
            }
            index--;
        }

        return firstDigit * 10 + secondDigit;
    }
}
