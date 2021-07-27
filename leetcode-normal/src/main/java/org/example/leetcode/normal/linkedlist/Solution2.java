package org.example.leetcode.normal.linkedlist;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author lifei
 */
public class Solution2 {
    /**
     * 模拟
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int n1;
        int n2;
        int sum;
        // 是否进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            n1 = l1 != null ? l1.val : 0;
            n2 = l2 != null ? l2.val : 0;
            sum = n1 + n2 + carry;
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
        System.out.println(
                new Solution2().addTwoNumbers(
                        ListNode.parseArray(new int[]{9, 9, 9, 9, 9, 9, 9}),
                        ListNode.parseArray(new int[]{9, 9, 9, 9})
                )
        );
    }
}
