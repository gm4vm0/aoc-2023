package aoc2023.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartTwoTest {
    @Test
    public void test() {
        long result = PartTwo.process("""
                Time:      7  15   30
                Distance:  9  40  200""");
        assertEquals(71503L, result);
    }
}