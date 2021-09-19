package org.example.leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution19 {
    /**
     * 双指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
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
        ListNode head = ListNodeUtils.parseArray(new int[]{1, 2, 3, 4, 5});
        ListNode ans = new Solution19().removeNthFromEnd(head, 2);
        System.out.println(ListNodeUtils.toList(ans));
    }
}
