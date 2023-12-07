package aoc2023.daysix;

import aoc2023.utils.InputParser;

import java.io.IOException;

public class PartTwo {
    private static final String INPUT_FILE = "inputs/day-six.txt";

    public static void main(String[] args) throws IOException {
        long result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static long process(String input) {
        String[] lines = input.split("\\n");
        long time = Long.parseLong(lines[0].replaceAll("Time: +", "")
                                           .replaceAll(" ", ""));
        long distance = Long.parseLong(lines[1].replaceAll("Distance: +", "")
                                               .replaceAll(" ", ""));

        return processRace(time, distance);
    }

    private static long processRace(long time, long distance) {
        double discriminant = Math.sqrt(Math.pow(time, 2) - (4 * distance));
        double root1 = Math.ceil((time + discriminant) / 2 - 1);
        double root2 = Math.floor((time - discriminant) / 2 + 1);

        return (long) (root1 - root2) + 1;
    }
}
