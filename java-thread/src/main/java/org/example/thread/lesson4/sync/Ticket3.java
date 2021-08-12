package org.example.thread.lesson4.sync;

/**
 * @author lifei
 */
public class Ticket3 {
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            private int ticket = 10;

            public synchronized boolean sale() {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            " 买走一张票，剩余票数：" + --ticket);
                    return true;
                } else {
                    System.out.println(Thread.currentThread().getName() +
                            " 发现票已卖完");
                    return false;
                }
            }

            @Override
            public void run() {
                while (sale()) {
                }
            }
        };
        new Thread(run, "thread-1").start();
        new Thread(run, "thread-2").start();
        new Thread(run, "thread-3").start();
    }
}
