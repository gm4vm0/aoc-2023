package aoc2023.day08;

import aoc2023.utils.InputParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PartOne {
    private static final String INPUT_FILE = "inputs/day08.txt";

    public static void main(String[] args) throws IOException {
        int result = process(InputParser.getInput(INPUT_FILE));
        System.out.println(result);
    }

    public static int process(String input) {
        String[] lines = input.split("\\n+");

        String[] instructions = lines[0].split("");

        Map<String, String> nodes = new HashMap<>();
        for (int i = 1; i < lines.length; i++) {
            String[] node = lines[i].split(" = ");
            nodes.put(node[0], node[1]);
        }

        boolean foundZZZ = false;
        String currentNode = "AAA";
        int currentInstruction = 0;
        int count = 0;
        while (!foundZZZ) {
            count++;
            String node = nodes.get(currentNode);
            String instruction = instructions[currentInstruction];
            if ("L".equals(instruction)) {
                currentNode = node.substring(1, 4);
            } else {
                currentNode = node.substring(6, 9);
            }
            if ("ZZZ".equals(currentNode)) {
                foundZZZ = true;
            }
            currentInstruction = currentInstruction >= instructions.length - 1
                    ? 0 : currentInstruction + 1;
        }

        return count;
    }
}
