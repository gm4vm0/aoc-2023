package aoc2023.day02;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartTwo {
    private static final String INPUT_FILE = "inputs/day-two.txt";

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
        Map<String, Integer> minimumRequired = new HashMap<>();

        String[] sets = input.replaceFirst("Game \\d+: ", "").split("; ");
        for (String set : sets) {
            String[] subsets = set.split(", ");
            for (String subset : subsets) {
                String[] colorCount = subset.split(" ");
                int count = Integer.parseInt(colorCount[0]);
                String color = colorCount[1];
                if (!minimumRequired.containsKey(color) || count > minimumRequired.get(color)) {
                    minimumRequired.put(color, count);
                }
            }
        }

        return minimumRequired.values().stream().reduce(1, (a, b) -> a * b);
    }
}
