package org.example.leetcode.normal.solution18;

import org.junit.Test;

public class Solution1Test {
    @Test
    public void test() {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(solution1.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
        System.out.println(solution1.fourSum(new int[]{-5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5}, 0));
    }
}
