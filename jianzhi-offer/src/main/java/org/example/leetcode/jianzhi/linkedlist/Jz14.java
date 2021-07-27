package org.example.leetcode.jianzhi.linkedlist;

/**
 * https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=13&tqId=11167
 *
 * @author lifei
 */
public class Jz14 {
    /**
     * 两次循环
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode head = pHead;
        ListNode tail = pHead;
        while (k-- > 0) {
            if (tail != null) {
                tail = tail.next;
            } else {
                return null;
            }
        }
        while (tail != null) {
            tail = tail.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz14().FindKthToTail(
                        ListNode.parseArray(new int[]{1, 2, 3, 4, 5}),
                        6
                )
        );
    }
}
