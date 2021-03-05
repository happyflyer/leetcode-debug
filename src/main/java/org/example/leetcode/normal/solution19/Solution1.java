package org.example.leetcode.normal.solution19;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author lifei
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            len++;
            p = p.next;
        }
        // 如果删除第一个节点，就直接返回从第二个节点开始
        if (n == len) {
            return head.next;
        }
        // 找到被删除元素的前一个元素
        ListNode target = head;
        for (int i = 1; i < len - n; i++) {
            if (target.next != null) {
                target = target.next;
            }
        }
        // target 为被删除元素的前一个元素
        if (target.next != null) {
            target.next = target.next.next;
        }
        return head;
    }
}
