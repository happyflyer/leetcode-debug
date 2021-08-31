package org.example.leetcode.linkedlist;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution2 {
    /**
     * 归并。
     */
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

    /**
     * 归并。
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int n1;
        int n2;
        int sum;
        int carry = 0;
        while (l1 != null || l2 != null) {
            n1 = l1 != null ? l1.val : 0;
            n2 = l2 != null ? l2.val : 0;
            sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.parseArray(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.parseArray(new int[]{9, 9, 9, 9});
        System.out.println(
                Arrays.toString(
                        ListNode.toArray(
                                new Solution2().addTwoNumbers(l1, l2)
                        )
                )
        );
    }
}
