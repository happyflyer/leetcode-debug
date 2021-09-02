package org.example.leetcode.linkedlist;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution24 {
    /**
     * 递归
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 迭代
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode cur = newHead;
        ListNode node1;
        ListNode node2;
        while (cur.next != null && cur.next.next != null) {
            node1 = cur.next;
            node2 = cur.next.next;
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            cur = node1;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.parseArray(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(
                Arrays.toString(
                        ListNode.toArray(
                                new Solution24().swapPairs(head)
                        )
                )
        );
    }
}
