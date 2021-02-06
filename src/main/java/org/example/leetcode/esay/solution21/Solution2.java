package org.example.leetcode.esay.solution21;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author lifei
 */
class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 迭代
        // 分别有两个哨兵，指向l1和l2
        // preHead的next指针指向元素小的哨兵，并将该哨兵往后移动
        // 最后剩下的l1或l2，全部接上就可以
        // 时间复杂度：O(n+m)
        // 空间复杂度：O(1)
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
