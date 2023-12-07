package aoc2023.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class InputParser {
    public static String getInput(String resource) throws IOException {
        ClassLoader classLoader = InputParser.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(resource)).getFile());
        try (InputStream inputStream = new FileInputStream(file)) {
            return new String(inputStream.readAllBytes());
        }
    }
}
