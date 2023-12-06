package aoc2023.dayfive;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PartOne {
    private static final String INPUT_FILE = "inputs/day-five.txt";

    public static void main(String[] args) throws IOException {
        long result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static long process(String input) {
        List<String> maps = new LinkedList<>(List.of(input.split("\\n\\n")));

        List<Long> seeds = Arrays.stream(maps.removeFirst().substring(7).split(" "))
                                 .map(Long::parseLong)
                                 .collect(Collectors.toList());

        return calculateDestination(seeds, maps).stream().min(Long::compareTo).orElseThrow(RuntimeException::new);
    }

    // recursive function to calculate next set of destinations
    private static List<Long> calculateDestination(List<Long> sources, List<String> maps) {
        if (maps.isEmpty()) {
            return sources;
        }

        String currentMap = maps.removeFirst().replaceFirst(".*\\n", "");

        Set<Integer> changedIndices = new HashSet<>();
        for (String line : currentMap.split("\\n")) {
            String[] numbers = line.split(" ");
            long destinationRangeStart = Long.parseLong(numbers[0]);
            long sourceRangeStart = Long.parseLong(numbers[1]);
            int range = Integer.parseInt(numbers[2]);

            for (int i = 0; i < sources.size(); i++) {
                long source = sources.get(i);
                if (source >= sourceRangeStart && source < (sourceRangeStart + range)) {
                    if (changedIndices.add(i)) {
                        sources.set(i, destinationRangeStart + source - sourceRangeStart);
                    }
                }
            }
        }

        return calculateDestination(sources, maps);
    }
}
