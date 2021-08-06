package org.example.leetcode.lang.thread.sync.version2;

/**
 * @author lifei
 */
public class MainClass {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Producer(message), "producer").start();
        new Thread(new Consumer(message), "consumer").start();
    }
}
