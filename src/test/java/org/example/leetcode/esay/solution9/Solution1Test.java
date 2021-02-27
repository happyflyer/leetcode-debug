package org.example.leetcode.esay.solution9;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution1Test {
    @Test
    public void test() {
        Solution1 solution1 = new Solution1();
        assertTrue(solution1.isPalindrome(121));
        assertFalse(solution1.isPalindrome(-121));
        assertFalse(solution1.isPalindrome(-10));
        assertFalse(solution1.isPalindrome(-101));
    }
}
