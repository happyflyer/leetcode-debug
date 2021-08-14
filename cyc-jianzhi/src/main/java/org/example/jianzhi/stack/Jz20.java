package org.example.jianzhi.stack;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173
 *
 * @author lifei
 */
public class Jz20 {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Jz20 jz20 = new Jz20();
        jz20.push(-1);
        jz20.push(2);
        System.out.println(jz20.min());
        System.out.println(jz20.top());
        jz20.pop();
        jz20.push(1);
        System.out.println(jz20.top());
        System.out.println(jz20.min());
    }
}
