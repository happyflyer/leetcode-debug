package org.example.leetcode.lang.thread.sync;

/**
 * @author lifei
 */
public class VolatileDemo {
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            private volatile int ticket = 10;

            @Override
            public void run() {
                synchronized (this) {
                    while (ticket > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() +
                                " 买走一张票，剩余票数：" + ticket--);
                    }
                }
            }
        };
        new Thread(run, "thread-1").start();
        new Thread(run, "thread-2").start();
        new Thread(run, "thread-3").start();
    }
}
