package org.example.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lifei
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}' + (next != null ? (" -> " + next) : "");
    }

    static ListNode parseArray(int[] arr) {
        return parseList(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    static ListNode parseList(List<Integer> list) {
        ListNode head = new ListNode();
        ListNode tail = head;
        for (Integer integer : list) {
            tail.next = new ListNode(integer);
            tail = tail.next;
        }
        return head.next;
    }

    static int[] toArray(ListNode head) {
        return toList(head).stream().mapToInt(Integer::valueOf).toArray();
    }

    static List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
