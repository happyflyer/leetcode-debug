package org.example.leetcode.jianzhi.linkedlist;

/**
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169
 *
 * @author lifei
 */
public class Jz16 {
    /**
     * 递归
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz16().Merge(
                        ListNode.parseArray(new int[]{1, 3, 5}),
                        ListNode.parseArray(new int[]{2, 3, 4})
                )
        );
    }
}
