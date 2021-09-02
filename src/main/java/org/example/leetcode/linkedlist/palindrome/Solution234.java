package org.example.leetcode.linkedlist.palindrome;

import org.example.leetcode.linkedlist.ListNode;
import org.example.leetcode.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution234 {
    /**
     * 回文字符串
     */
    public String palindrome(String s, int left, int right) {
        while (left > 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left, right + 1);
    }

    /**
     * 判断回文字符串
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 二叉树遍历的递归结构
     */
    public void traverse(TreeNode root) {
        // 前序遍历代码
        traverse(root.left);
        // 中序遍历代码
        traverse(root.right);
        // 后序遍历代码
    }

    /**
     * 链表遍历的递归结构
     */
    public void traverse(ListNode head) {
        // 前序遍历代码
        traverse(head.next);
        // 后续遍历代码
    }

    /**
     * 回文链表
     */
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse2(head);
    }

    ListNode left;

    public boolean traverse2(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse2(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    /**
     * 回文链表
     */
    public boolean isPalindrome2(ListNode head) {
        // 1、通过快慢指针找到中点。
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
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

    /**
     * 反转链表
     */
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
