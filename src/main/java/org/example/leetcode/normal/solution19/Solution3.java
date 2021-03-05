package org.example.leetcode.normal.solution19;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author lifei
 */
public class Solution3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 一般涉及单链表最前面都要加一个没有数据val的头节点，
        // 这样就不需要单独判断头结点的情况了
        ListNode newHead = new ListNode();
        newHead.next = head;
        int len = 0;
        ListNode p = newHead;
        ListNode target = newHead;
        while (p.next != null) {
            len++;
            if (len > n) {
                target = target.next;
            }
            p = p.next;
        }
        if (target.next != null) {
            target.next = target.next.next;
        }
        return newHead.next;
    }
}
