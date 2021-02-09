package org.example.leetcode.normal.solution2;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author lifei
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode();
        ListNode tail = head;
        int n1;
        int n2;
        // 避免去判断l1为空或l2为空，而是直接补0
        while (l1 != null || l2 != null) {
            n1 = l1 != null ? l1.val : 0;
            n2 = l2 != null ? l2.val : 0;
            tail.next = new ListNode();
            tail = tail.next;
            tail.val = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            tail.next = new ListNode(1);
        }
        return head.next;
    }
}
