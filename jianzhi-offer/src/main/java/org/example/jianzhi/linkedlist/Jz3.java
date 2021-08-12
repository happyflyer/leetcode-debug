package org.example.jianzhi.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156
 *
 * @author lifei
 */
public class Jz3 {
    /**
     * 使用逆序 API
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 递归
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        } else {
            ArrayList<Integer> list = printListFromTailToHead2(listNode.next);
            list.add(listNode.val);
            return list;
        }
    }

    /**
     * 头插法
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    /**
     * 使用栈
     */
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz3().printListFromTailToHead4(
                        ListNode.parseArray(new int[]{67, 0, 24, 58})
                )
        );
    }
}
