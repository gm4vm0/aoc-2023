package aoc2023.utils;

import aoc2023.dayone.PartOne;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class InputParser {
    public static String getInput(String resource) throws IOException {
        ClassLoader classLoader = PartOne.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(resource)).getFile());
        try (InputStream inputStream = new FileInputStream(file)) {
            return new String(inputStream.readAllBytes());
        }
    }
}
