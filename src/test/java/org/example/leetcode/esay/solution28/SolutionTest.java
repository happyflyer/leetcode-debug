package org.example.leetcode.esay.solution28;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        // Solution solution = new Solution();
        Solution2 solution = new Solution2();
        assertEquals(2, solution.strStr("hello", "ll"));
        assertEquals(-1, solution.strStr("mississippi", "issipi"));
        assertEquals(0, solution.strStr("mississippi", "mississippi"));
        assertEquals(0, solution.strStr("abc", ""));
        assertEquals(0, solution.strStr("", ""));
    }
}
