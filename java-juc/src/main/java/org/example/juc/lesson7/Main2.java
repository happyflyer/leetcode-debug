package org.example.juc.lesson7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author lifei
 */
public class Main2 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer("a"));
        System.out.println(queue.offer("b"));
        System.out.println(queue.offer("c"));
        System.out.println(queue.peek());
        System.out.println(queue.offer("w"));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
