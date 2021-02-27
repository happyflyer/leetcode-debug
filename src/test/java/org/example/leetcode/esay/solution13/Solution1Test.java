package org.example.leetcode.esay.solution13;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1Test {
    @Test
    public void test() {
        Solution1 solution1 = new Solution1();
        assertEquals(3, solution1.romanToInt("III"));
        assertEquals(4, solution1.romanToInt("IV"));
        assertEquals(9, solution1.romanToInt("IX"));
        assertEquals(58, solution1.romanToInt("LVIII"));
        assertEquals(1994, solution1.romanToInt("MCMXCIV"));
    }
}
