package aoc2023.day08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartOneTest {
    @Test
    public void testOne() {
        int result = PartOne.process("""
                RL
                            
                AAA = (BBB, CCC)
                BBB = (DDD, EEE)
                CCC = (ZZZ, GGG)
                DDD = (DDD, DDD)
                EEE = (EEE, EEE)
                GGG = (GGG, GGG)
                ZZZ = (ZZZ, ZZZ)""");
        assertEquals(2, result);
    }

    @Test
    public void testTwo() {
        int result = PartOne.process("""
                LLR
                            
                AAA = (BBB, BBB)
                BBB = (AAA, ZZZ)
                ZZZ = (ZZZ, ZZZ)""");
        assertEquals(6, result);
    }
}