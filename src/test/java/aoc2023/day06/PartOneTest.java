package aoc2023.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartOneTest {
    @Test
    public void test() {
        int result = PartOne.process("""
                Time:      7  15   30
                Distance:  9  40  200""");
        assertEquals(288, result);
    }
}