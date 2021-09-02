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

    public boolean isPalindrome(ListNode head) {
        return false;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.parseArray(new int[]{1, 2, 2, 1});
        System.out.println(
                new Solution234().isPalindrome(head)
        );
    }
}
