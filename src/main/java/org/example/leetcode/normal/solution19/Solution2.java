package org.example.leetcode.normal.solution19;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author lifei
 */
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 进阶：你能尝试使用一趟扫描实现吗？
        int len = 1;
        ListNode p = head;
        ListNode target = head;
        while (p.next != null) {
            len++;
            if (len > n + 1) {
                target = target.next;
            }
            p = p.next;
        }
        if (n == len) {
            return head.next;
        }
        if (target.next != null) {
            target.next = target.next.next;
        }
        return head;
    }
}
