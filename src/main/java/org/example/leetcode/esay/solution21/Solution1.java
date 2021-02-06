package org.example.leetcode.esay.solution21;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author lifei
 */
class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 递归
        // 考虑l1或l2中有空链表
        // l1和l2都不是空链表时，
        // l1[0]<=l2[0]时
        // l1[0]+merge(l1[1:], l2)
        // 其他情况
        // l2[0]+merge(l1, l2[1:])
        // 时间复杂度：O(n+m)
        // 空间复杂度：消耗栈空间，O(n+m)
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
