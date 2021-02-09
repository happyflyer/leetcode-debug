package org.example.leetcode.normal.solution2;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtil {
    public static ListNode list2ListNode(List<Integer> list) {
        ListNode head = new ListNode();
        ListNode tail = head;
        for (int j : list) {
            tail.next = new ListNode(j);
            tail = tail.next;
        }
        return head.next;
    }

    public static List<Integer> ListNode2List(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}
