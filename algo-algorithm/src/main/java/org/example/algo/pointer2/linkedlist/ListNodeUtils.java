package org.example.algo.pointer2.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lifei
 */
public class ListNodeUtils {
    /**
     * 构造。
     */
    public static ListNode parseArray(int[] arr) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for (int i : arr) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        return head.next;
    }

    /**
     * 打印。
     */
    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    /**
     * 查找。
     */
    public static ListNode find(ListNode head, int val) {
        while (head != null) {
            if (head.val == val) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = parseArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(toList(head));
    }
}
