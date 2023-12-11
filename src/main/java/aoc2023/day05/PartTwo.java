package aoc2023.day05;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartTwo {
    private static final String INPUT_FILE = "inputs/day05.txt";

    public static void main(String[] args) throws IOException {
        long result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static long process(String input) {
        String[] maps = input.split("\\n\\n");

        String[] sources = maps[0].replaceFirst("seeds: ", "").split(" ");
        List<long[]> startingRanges = new ArrayList<>();
        for (int i = 0; i < sources.length; i += 2) {
            long rangeStart = Long.parseLong(sources[i]);
            long range = Long.parseLong(sources[i + 1]);
            startingRanges.add(new long[]{rangeStart, rangeStart + range});
        }


        for (int mapIndex = 1; mapIndex < maps.length; mapIndex++) {
            String[] lines = maps[mapIndex].replaceFirst(".*\\n", "").split("\\n");

            List<long[]> newRanges = new ArrayList<>();

            while (!startingRanges.isEmpty()) {
                long[] startingRange = startingRanges.removeLast();
                boolean mapped = false;
                for (String line : lines) {
                    long[] numbers = Arrays.stream(line.split(" ")).mapToLong(Long::parseLong).toArray();
                    long destinationStart = numbers[0];
                    long sourceStart = numbers[1];
                    long range = numbers[2];
                    long difference = destinationStart - sourceStart;

                    long overlapStart = Math.max(startingRange[0], sourceStart);
                    long overlapEnd = Math.min(startingRange[1], sourceStart + range);

                    if (overlapStart < overlapEnd) {
                        mapped = true;
                        newRanges.add(new long[]{overlapStart + difference, overlapEnd + difference});
                        if (overlapStart > startingRange[0]) {
                            startingRanges.add(new long[]{startingRange[0], overlapStart});
                        }
                        if (startingRange[1] > overlapEnd) {
                            startingRanges.add(new long[]{overlapEnd, startingRange[1]});
                        }
                        break;
                    }
                }
                if (!mapped) {
                    newRanges.add(startingRange);
                }
            }

            startingRanges = newRanges;
        }

        return startingRanges.stream().mapToLong(startingRange -> startingRange[0]).min().getAsLong();
    }
}
