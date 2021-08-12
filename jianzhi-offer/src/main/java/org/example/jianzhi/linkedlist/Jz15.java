package org.example.jianzhi.linkedlist;

/**
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168
 *
 * @author lifei
 */
public class Jz15 {
    /**
     * 递归
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode newHead = ReverseList(head.next);
            ListNode tail = newHead;
            while (tail.next != null) {
                tail = tail.next;
            }
            head.next = null;
            tail.next = head;
            return newHead;
        }
    }

    /**
     * 递归
     */
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pNext = head.next;
        head.next = null;
        ListNode newHead = ReverseList2(pNext);
        pNext.next = head;
        return newHead;
    }

    /**
     * 迭代 / 头插法
     */
    public ListNode ReverseList3(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode pNext = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = pNext;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz15().ReverseList(
                        // ListNode.parseArray(new int[]{1, 2, 3, 4})
                        ListNode.parseArray(new int[]{})
                )
        );
    }
}
