package org.example.leetcode.linkedlist.reverse;

import org.example.leetcode.linkedlist.ListNode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution25 {
    /**
     * 反转整个链表
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 反转部分链表
     */
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null;
        ListNode cur = a;
        ListNode next;
        while (cur != b) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * K个一组翻转链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.parseArray(new int[]{1, 2, 3, 4, 5});
        ListNode a = ListNode.find(head, 2);
        ListNode b = ListNode.find(head, 4);
        System.out.println(
                Arrays.toString(
                        ListNode.toArray(
                                // new Solution25().reverse(head)
                                // new Solution25().reverse(a, b)
                                new Solution25().reverseKGroup(head, 3)
                        )
                )
        );
    }
}
