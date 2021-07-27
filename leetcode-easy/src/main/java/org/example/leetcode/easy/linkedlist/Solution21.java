package org.example.leetcode.easy.linkedlist;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author lifei
 */
public class Solution21 {
    /**
     * 递归
     * <p>
     * 考虑 l1 或 l2 中有空链表
     * <p>
     * l1 和 l2 都不是空链表时，
     * l1[0]<=l2[0] 时
     * l1[0]+merge(l1[1:], l2)
     * <p>
     * 其他情况
     * l2[0]+merge(l1, l2[1:])
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    /**
     * 迭代
     * <p>
     * 分别有两个哨兵，指向 l1 和 l2
     * head 的 tail 指针指向元素小的哨兵，并将该哨兵往后移动
     * <p>
     * 最后剩下的 l1 或 l2 ，全部接上就可以
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution21().mergeTwoLists(
                        ListNode.parseArray(new int[]{1, 2, 4}),
                        ListNode.parseArray(new int[]{1, 3, 4})
                )
        );
    }
}
