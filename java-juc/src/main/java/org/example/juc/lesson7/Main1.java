package org.example.juc.lesson7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author lifei
 */
public class Main1 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add("a"));
        System.out.println(queue.add("b"));
        System.out.println(queue.add("c"));
        System.out.println(queue.element());
        // System.out.println(queue.add("w"));
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        // System.out.println(queue.remove());
    }
}
