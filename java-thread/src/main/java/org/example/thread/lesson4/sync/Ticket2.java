package org.example.thread.lesson4.sync;

/**
 * @author lifei
 */
public class Ticket2 {
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            private int ticket = 10;

            @Override
            public void run() {
                while (true) {
                    synchronized (this) {
                        if (ticket > 0) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() +
                                    " 买走一张票，剩余票数：" + --ticket);
                        } else {
                            System.out.println(Thread.currentThread().getName() +
                                    " 发现票已卖完");
                            break;
                        }
                    }
                }
            }
        };
        new Thread(run, "thread-1").start();
        new Thread(run, "thread-2").start();
        new Thread(run, "thread-3").start();
    }
}
