package org.example.jianzhi.linkedlist;

/**
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208
 *
 * @author lifei
 */
public class Jz55 {
    /**
     * 双指针
     * <p>
     * 两个结论：
     * 1、设置快慢指针，假如有环，他们最后一定相遇。
     * 2、两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == null || fast == null || fast.next == null) {
            return null;
        }
        slow = pHead;
        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 判断是否有环
     */
    private boolean hasCircle(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node3;
        System.out.println(
                new Jz55().EntryNodeOfLoop(node1).val
        );
    }
}
