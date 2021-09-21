package org.example.algo.pointer2.linkedlist;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
    }
}
