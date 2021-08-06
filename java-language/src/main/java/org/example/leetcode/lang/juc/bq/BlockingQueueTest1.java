package org.example.leetcode.lang.juc.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列方法：
 * 1、抛出异常：add(e), remove(), element()
 * 2、特殊值：offer(e), poll(), peek()
 * 3、阻塞：put(), take()
 * 4、超时：offer(e,time,unit), poll(time,unit)
 *
 * @author lifei
 */
public class BlockingQueueTest1 {
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
