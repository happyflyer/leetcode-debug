package org.example.leetcode.esay.solution28;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2Test {
    @Test
    public void test() {
        Solution2 solution2 = new Solution2();
        assertEquals(2, solution2.strStr("hello", "ll"));
        assertEquals(-1, solution2.strStr("mississippi", "issipi"));
        assertEquals(0, solution2.strStr("mississippi", "mississippi"));
        assertEquals(0, solution2.strStr("abc", ""));
        assertEquals(0, solution2.strStr("", ""));
    }
}
