package org.example.leetcode.linkedlist.merge;

import org.example.leetcode.linkedlist.ListNode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution21 {
    /**
     * 递归
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.parseArray(new int[]{1, 2, 4});
        ListNode l2 = ListNode.parseArray(new int[]{1, 3, 4});
        System.out.println(
                Arrays.toString(
                        ListNode.toArray(
                                // new Solution21().mergeTwoLists(l1, l2)
                                new Solution21().mergeTwoLists2(l1, l2)
                        )
                )
        );
    }
}
