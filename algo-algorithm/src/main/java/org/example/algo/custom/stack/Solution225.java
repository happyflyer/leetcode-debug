package org.example.algo.custom.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution225 {

    class MyStack {
        Queue<Integer> queue;
        int topElem = 0;

        public MyStack() {
            this.queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            topElem = x;
        }

        public int pop() {
            int size = queue.size();
            while (size > 2) {
                queue.offer(queue.poll());
                size--;
            }
            topElem = queue.peek();
            queue.offer(queue.poll());
            return queue.poll();
        }

        public int top() {
            return topElem;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
    }
}
