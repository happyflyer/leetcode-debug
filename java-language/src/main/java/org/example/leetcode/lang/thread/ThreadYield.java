package org.example.leetcode.lang.thread;

/**
 * @author lifei
 */
public class ThreadYield {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i % 3 == 0) {
                    Thread.yield();
                    System.out.println(Thread.currentThread().getName() + " 线程执行礼让");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 线程，i=" + i);
            }
        });
        thread.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " 线程，i=" + i);
        }
    }
}
