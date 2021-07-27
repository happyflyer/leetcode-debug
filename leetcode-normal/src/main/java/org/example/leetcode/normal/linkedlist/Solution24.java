package org.example.leetcode.normal.linkedlist;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
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
        System.out.println(
                new Solution24().swapPairs(
                        ListNode.parseArray(new int[]{1, 2, 3, 4, 5, 6, 7})
                )
        );
    }
}
