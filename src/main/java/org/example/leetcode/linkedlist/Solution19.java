package org.example.leetcode.linkedlist;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution19 {
    /**
     * 前后指针。
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        int len = 0;
        ListNode tail = newHead;
        ListNode target = newHead;
        while (tail.next != null) {
            len++;
            if (len > n) {
                target = target.next;
            }
            tail = tail.next;
        }
        if (target.next != null) {
            target.next = target.next.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.parseArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(
                Arrays.toString(
                        ListNode.toArray(
                                new Solution19().removeNthFromEnd3(head, 2)
                        )
                )
        );
    }
}
