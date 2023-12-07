package aoc2023.day02;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartOne {
    private static final String INPUT_FILE = "inputs/day-two.txt";

    private static final Map<String, Integer> MAXIMUMS = new HashMap<>() {{
        put("red", 12);
        put("green", 13);
        put("blue", 14);
    }};

    public static void main(String[] args) throws IOException {
        int result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static int process(String input) {
        String[] inputs = input.split("\\n");
        return Arrays.stream(inputs)
                     .mapToInt((line) -> isValidLine(line) ? getGameId(line) : 0)
                     .sum();
    }

    private static int getGameId(String input) {
        String gameId = input.split(":")[0].substring(5);
        return Integer.parseInt(gameId);
    }

    private static boolean isValidLine(String input) {
        input = input.replaceFirst("Game \\d+: ", "");
        String[] sets = input.split("; ");

        return Arrays.stream(sets)
                     .allMatch(PartOne::isValidSet);
    }

    private static boolean isValidSet(String input) {
        String[] subsets = input.split(", ");
        for (String subset : subsets) {
            String[] colorCount = subset.split(" ");
            int count = Integer.parseInt(colorCount[0]);
            String color = colorCount[1];
            if (count > MAXIMUMS.get(color)) {
                return false;
            }
        }

        return true;
    }
}
