package org.example.leetcode.linkedlist.palindrome;

import org.example.leetcode.linkedlist.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution234 {
    /**
     * 递归
     */
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    ListNode left;

    public boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    /**
     * 翻转链表后半部分
     */
    public boolean isPalindrome2(ListNode head) {
        // 1、通过快慢指针找到中点。
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 奇数情况
        if (fast != null) {
            slow = slow.next;
        }
        // 2、反转后半部分开始比较
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.parseArray(new int[]{1, 2, 3, 2, 1});
        System.out.println(
                // new Solution234().isPalindrome(head)
                new Solution234().isPalindrome2(head)
        );
    }
}
