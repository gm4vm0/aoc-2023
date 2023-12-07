package aoc2023.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartOneTest {
    @Test
    public void test() {
        int result = PartOne.process("""
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet""");
        assertEquals(142, result);
    }
}