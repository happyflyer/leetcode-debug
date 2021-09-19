package org.example.leetcode.linkedlist.merge;

import org.example.leetcode.linkedlist.ListNode;
import org.example.leetcode.linkedlist.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution2 {
    /**
     * 归并
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.parseArray(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNodeUtils.parseArray(new int[]{9, 9, 9, 9});
        ListNode ans = new Solution2().addTwoNumbers(l1, l2);
        System.out.println(ListNodeUtils.toList(ans));
    }
}
