package org.example.leetcode.linkedlist.reverse;

import org.example.leetcode.linkedlist.ListNode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution92 {
    /**
     * 翻转整个链表
     */
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 翻转链表前N个节点
     */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    ListNode successor = null;

    /**
     * 翻转链表的一部分
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.parseArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(
                Arrays.toString(
                        ListNode.toArray(
                                // new Solution92().reverse(head)
                                // new Solution92().reverseN(head, 3)
                                new Solution92().reverseBetween(head, 2, 4)
                        )
                )
        );
    }
}
