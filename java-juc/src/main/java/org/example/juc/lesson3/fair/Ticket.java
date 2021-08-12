package org.example.juc.lesson3.fair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lifei
 */
public class Ticket {
    private int number = 30;
    private final ReentrantLock lock = new ReentrantLock(true);

    public void sale() {
        this.lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName()
                        + "卖出一张票，剩下：" + --number);
            }
        } finally {
            lock.unlock();
        }
    }
}
