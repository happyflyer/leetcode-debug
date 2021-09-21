package org.example.algo.pointer2.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n-- > 0) {
            // 链表长度小于n
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        // 链表长度正好等于n
        if (fast == null) {
            return head != null ? head.next : null;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.parseArray(new int[]{1, 2, 3, 4, 5});
        int n = 6;
        ListNode ans = new Solution19().removeNthFromEnd(head, n);
        System.out.println(ListNodeUtils.toList(ans));
    }
}
