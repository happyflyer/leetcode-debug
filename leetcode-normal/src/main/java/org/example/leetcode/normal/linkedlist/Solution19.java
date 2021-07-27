package org.example.leetcode.normal.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author lifei
 */
public class Solution19 {
    /**
     * 两次遍历
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode tail = head;
        // 获得链表长度
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        // 如果删除第一个节点，就直接返回从第二个节点开始
        if (n == len) {
            return head.next;
        }
        // 找到被删除节点的前一个节点
        ListNode target = head;
        for (int i = 1; i < len - n; i++) {
            if (target.next != null) {
                target = target.next;
            }
        }
        // 删除节点
        if (target.next != null) {
            target.next = target.next.next;
        }
        return head;
    }

    /**
     * 进阶：你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int len = 1;
        ListNode tail = head;
        ListNode target = head;
        while (tail.next != null) {
            // 获得链表长度
            len++;
            // 找到被删除节点的前一个节点
            if (len > n + 1) {
                target = target.next;
            }
            tail = tail.next;
        }
        if (n == len) {
            return head.next;
        }
        if (target.next != null) {
            target.next = target.next.next;
        }
        return head;
    }

    /**
     * 一般涉及单链表最前面都要加一个没有数据val的头节点，
     * 这样就不需要单独判断头结点的情况了
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        int len = 0;
        ListNode tail = newHead;
        ListNode target = newHead;
        while (tail.next != null) {
            len++;
            if (len > n) {
                target = target.next;
            }
            tail = tail.next;
        }
        if (target.next != null) {
            target.next = target.next.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution19().removeNthFromEnd3(
                        ListNode.parseArray(new int[]{1, 2, 3, 4, 5}),
                        2
                )
        );
    }
}
