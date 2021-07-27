package org.example.leetcode.jianzhi.linkedlist;

/**
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209
 *
 * @author lifei
 */
public class Jz56 {
    /**
     * 重复值节点只保留一个
     */
    public ListNode duplication(ListNode pHead) {
        ListNode pCur = pHead;
        while (pCur != null && pCur.next != null) {
            if (pCur.val == pCur.next.val) {
                pCur.next = pCur.next.next;
            } else {
                pCur = pCur.next;
            }
        }
        return pHead;
    }

    /**
     * 前节点a，当前节点b，后节点c，
     * 如果：b.val!=c.val，那么 a.next=b, a=b, b=c；
     * 如果 b.val==c.val，那么 c=c.next，直到找到 b.val!=c.val，跳过整个b.val，b=c
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode a = new ListNode(Integer.MAX_VALUE);
        a.next = pHead;
        pHead = a;
        ListNode b = a.next;
        ListNode c;
        while (b != null) {
            c = b.next;
            if (c == null || b.val != c.val) {
                a.next = b;
                a = b;
                b = c;
                continue;
            }
            while (c != null && b.val == c.val) {
                c = c.next;
            }
            b = c;
        }
        a.next = b;
        return pHead.next;
    }

    /**
     * 递归
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode pNext = pHead.next;
        if (pHead.val == pNext.val) {
            while (pNext != null && pHead.val == pNext.val) {
                pNext = pNext.next;
            }
            return deleteDuplication2(pNext);
        } else {
            pHead.next = deleteDuplication2(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz56().deleteDuplication(
                        ListNode.parseArray(new int[]{1, 2, 3, 3, 4, 4, 5})
                        // ListNode.parseArray(new int[]{1, 1, 1, 1, 1, 1, 1})
                )
        );
    }
}
