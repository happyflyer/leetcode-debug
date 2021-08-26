package org.example.leetcode.hot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author lifei
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            tail.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            tail.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            tail = tail.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.parseArray(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.parseArray(new int[]{9, 9, 9, 9});
        System.out.println(
                Arrays.toString(
                        ListNode.toArray(
                                new LeetCode2().addTwoNumbers(l1, l2)
                        )
                )
        );
    }
}
