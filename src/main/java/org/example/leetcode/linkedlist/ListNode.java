package org.example.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lifei
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode parseArray(int[] arr) {
        return parseList(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public static ListNode parseList(List<Integer> list) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for (Integer integer : list) {
            tail.next = new ListNode(integer);
            tail = tail.next;
        }
        return head.next;
    }

    public static int[] toArray(ListNode head) {
        return toList(head).stream().mapToInt(Integer::valueOf).toArray();
    }

    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    public static ListNode find(ListNode head, int val) {
        while (head != null) {
            if (head.val == val) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
