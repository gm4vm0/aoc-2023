package aoc2023.day06;

import aoc2023.utils.InputParser;

import java.io.IOException;

public class PartOne {
    private static final String INPUT_FILE = "inputs/day06.txt";

    public static void main(String[] args) throws IOException {
        int result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static int process(String input) {
        String[] lines = input.split("\\n");
        String[] times = lines[0].replaceAll("Time: +", "").split(" +");
        String[] distances = lines[1].replaceAll("Distance: +", "").split(" +");

        int[][] races = new int[times.length][2];
        for (int i = 0; i < times.length; i++) {
            races[i] = new int[]{Integer.parseInt(times[i]), Integer.parseInt(distances[i])};
        }

        int product = 1;
        for (int[] race : races) {
            product *= processRace(race[0], race[1]);
        }

        return product;
    }

    private static int processRace(int time, int distance) {
        double discriminant = Math.sqrt(Math.pow(time, 2) - (4 * distance));
        double root1 = Math.ceil((time + discriminant) / 2 - 1);
        double root2 = Math.floor((time - discriminant) / 2 + 1);

        return (int) (root1 - root2) + 1;
    }
}
