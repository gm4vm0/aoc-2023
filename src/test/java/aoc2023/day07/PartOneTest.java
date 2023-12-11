package aoc2023.day07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartOneTest {
    @Test
    public void test() {
        int result = PartOne.process("""
                32T3K 765
                T55J5 684
                KK677 28
                KTJJT 220
                QQQJA 483""");
        assertEquals(6440, result);
    }
}