package org.example.leetcode.jianzhi.stack;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158
 *
 * @author lifei
 */
public class Jz5 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("没有元素可以出出栈");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Jz5 jz5 = new Jz5();
        jz5.push(1);
        jz5.push(2);
        System.out.println(jz5.pop());
        System.out.println(jz5.pop());
    }
}
