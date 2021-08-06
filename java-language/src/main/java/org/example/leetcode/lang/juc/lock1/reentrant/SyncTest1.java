package org.example.leetcode.lang.juc.lock1.reentrant;

/**
 * @author lifei
 */
public class SyncTest1 {
    public static void main(String[] args) {
        Object obj = new Object();
        new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + " 外层");
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + " 中层");
                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName() + " 内层");
                    }
                }
            }
        }, "AA").start();
    }
}
