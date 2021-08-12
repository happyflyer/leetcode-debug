package org.example.juc.lesson3.reentrant.sync;

/**
 * @author lifei
 */
public class Main1 {
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
