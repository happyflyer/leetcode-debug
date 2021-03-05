package org.example.leetcode.normal.solution19;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution1Test {
    @Test
    public void test() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        ListNode l1 = ListNodeUtil.list2ListNode(list1);
        // Solution1 solution1 = new Solution1();
        // Solution2 solution1 = new Solution2();
        Solution3 solution1 = new Solution3();
        ListNode head = solution1.removeNthFromEnd(l1, 5);
        // System.out.println(head.val);
        System.out.println(Arrays.toString(ListNodeUtil.ListNode2List(head).toArray()));
    }
}
