package aoc2023.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartTwoTest {
    @Test
    public void test() {
        int result = PartTwo.process("""
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen""");
        assertEquals(281, result);
    }
}
