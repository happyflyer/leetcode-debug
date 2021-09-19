package org.example.algo.linkedlist.reverse;

import org.example.algo.linkedlist.ListNode;
import org.example.algo.linkedlist.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution25 {
    /**
     * 翻转整个链表
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
     * 翻转部分链表
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
     * K 个一组翻转链表
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
        ListNode head = ListNodeUtils.parseArray(new int[]{1, 2, 3, 4, 5});
        // ListNode a = ListNodeUtils.find(head, 2);
        // ListNode b = ListNodeUtils.find(head, 4);
        ListNode ans = new Solution25().reverseKGroup(head, 3);
        System.out.println(ListNodeUtils.toList(ans));
    }
}
