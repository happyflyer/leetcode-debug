package org.example.leetcode.esay.solution38;

import org.junit.Test;

public class Solution1Test {
    @Test
    public void test() {
        Solution1 solution = new Solution1();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
        // 栈内存溢出
        for (int i = 0; i < 7; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }
}
