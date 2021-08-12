package org.example.juc.lesson1.signal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lifei
 */
public class Share {
    private int flag = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    public void print5(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()
                        + " :: " + (loop + 1) + " :: " + (i + 1));
            }
            flag = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()
                        + " :: " + (loop + 1) + " :: " + (i + 1));
            }
            flag = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()
                        + " :: " + (loop + 1) + " :: " + (i + 1));
            }
            flag = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}
