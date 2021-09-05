package org.example.exam.tencent2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入：[{1,2,3},{4,5},{7,8,9,10,11,12}]
 * 输出：{1,4,7,2,5,8,3,9,10,11,12}
 * <p>
 * 输入：[{1,3},{},{2}]
 * 输出：{1,2,3}
 * <p>
 * 57.14%
 *
 * @author lifei
 */
public class Solution1 {
    public ListNode solve(ListNode[] a) {
        Deque<ListNode> q = new LinkedList<>();
        for (ListNode node : a) {
            if (node != null) {
                q.addLast(node);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (!q.isEmpty()) {
            ListNode cur = q.removeFirst();
            if (cur != null) {
                tail.next = cur;
                tail = tail.next;
                cur = cur.next;
                q.addLast(cur);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
    }
}
