package org.example.exam.tencent1;

/**
 * 输入：5,{0,1,3,4,5,11,6}
 * 输出：[{0,5},{1,11,6},{},{3},{4}]
 * <p>
 * 输入：9,{7,8,13,11,15,0,10,15,9,9}
 * 输出：[{0,9,9},{10},{11},{},{13},{},{15,15},{7},{8}]
 *
 * @author lifei
 */
public class Solution1 {
    public ListNode[] solve(int m, ListNode a) {
        ListNode[] arr = new ListNode[m];
        ListNode newHead = new ListNode(-1);
        newHead.next = a;
        ListNode cur;
        for (int i = 0; i < m; i++) {
            cur = newHead;
            ListNode head = new ListNode(-1);
            ListNode tail = head;
            while (cur.next != null) {
                if (cur.next.val % m == i) {
                    tail.next = new ListNode(cur.next.val);
                    tail = tail.next;
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            arr[i] = head.next;
        }
        return arr;
    }

    public ListNode[] solve2(int m, ListNode a) {
        ListNode[] heads = new ListNode[m];
        ListNode[] tails = new ListNode[m];
        while (a != null) {
            int pos = a.val % m;
            if (heads[pos] == null) {
                heads[pos] = new ListNode(a.val);
                tails[pos] = heads[pos];
            } else {
                tails[pos].next = new ListNode(a.val);
                tails[pos] = tails[pos].next;
            }
            a = a.next;
        }
        return heads;
    }

    public static void main(String[] args) {
    }
}
