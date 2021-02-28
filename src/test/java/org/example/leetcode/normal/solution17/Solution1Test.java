package org.example.leetcode.normal.solution17;

import org.junit.Test;

import java.util.Arrays;

public class Solution1Test {
    @Test
    public void test() {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.getNewList(Arrays.asList("a", "b", "c"), "3"));
        System.out.println(solution1.letterCombinations("23"));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.letterCombinations("234"));;
    }
}
