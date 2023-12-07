package aoc2023.day03;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PartTwo {
    private static final String INPUT_FILE = "inputs/day-three.txt";

    public static void main(String[] args) throws IOException {
        int result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static int process(String input) {
        String[] lines = input.split("\\n");
        int width = lines[0].length();
        int height = lines.length;
        String[][] cells = new String[height][width];

        for (int y = 0; y < height; y++) {
            cells[y] = lines[y].split("");
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (cells[y][x].matches("\\d")) {
                    int initX = x;
                    String numberString = cells[y][x];
                    while (x < width - 1 && cells[y][++x].matches("\\d")) {
                        //noinspection StringConcatenationInLoop
                        numberString += cells[y][x];
                    }
                    for (int i = initX; i < x; i++) {
                        cells[y][i] = numberString;
                    }
                }
            }
        }

        int sum = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if ("*".equals(cells[y][x])) {
                    Set<Integer> alreadyAdded = new HashSet<>();
                    int count = 0;
                    int product = 1;

                    for (int dy = -1; dy <= 1; dy++) {
                        if (y + dy < 0 || y + dy >= height) {
                            continue;
                        }

                        for (int dx = -1; dx <= 1; dx++) {
                            if (x + dx < 0 || x + dx >= width) {
                                continue;
                            }

                            if (cells[y + dy][x + dx].matches("\\d+")) {
                                int number = Integer.parseInt(cells[y + dy][x + dx]);
                                if (!alreadyAdded.add(number)) {
                                    break;
                                }
                                count++;
                                product *= number;
                            }
                        }
                    }

                    if (count == 2) {
                        sum += product;
                    }
                }
            }
        }

        return sum;
    }
}
