package org.example.leetcode.normal.solution2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @Test
    public void test() {
        List<Integer> list1 = Arrays.asList(9, 9, 9, 9, 9, 9, 9);
        List<Integer> list2 = Arrays.asList(9, 9, 9, 9);
        ListNode l1 = ListNodeUtil.list2ListNode(list1);
        ListNode l2 = ListNodeUtil.list2ListNode(list2);
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println(Arrays.toString(list2.toArray()));
        System.out.println(Arrays.toString(ListNodeUtil.ListNode2List(result).toArray()));
    }
}
