package org.example.algo.pointer2.linkedlist;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
