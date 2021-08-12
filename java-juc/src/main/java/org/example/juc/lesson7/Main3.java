package org.example.juc.lesson7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author lifei
 */
public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        // queue.put("w");
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        // System.out.println(queue.take());
    }
}
