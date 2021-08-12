package org.example.jianzhi.linkedlist;

/**
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189
 *
 * @author lifei
 */
public class Jz36 {
    /**
     * 双指针
     * <p>
     * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，
     * 可知 a + c + b = b + c + a。
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode pCur1 = pHead1;
        ListNode pCur2 = pHead2;
        while (pCur1 != pCur2) {
            pCur1 = pCur1 != null ? pCur1.next : pHead2;
            pCur2 = pCur2 != null ? pCur2.next : pHead1;
        }
        return pCur1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        ListNode node8 = ListNode.parseArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(
                new Jz36().FindFirstCommonNode(node1, node4)
                // new Jz36().FindFirstCommonNode(node8, node8)
        );
    }
}
