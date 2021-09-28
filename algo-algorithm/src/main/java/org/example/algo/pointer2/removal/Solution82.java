package org.example.algo.pointer2.removal;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.parseArray(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(ListNodeUtils.toList(new Solution82().deleteDuplicates(head)));
    }
}
