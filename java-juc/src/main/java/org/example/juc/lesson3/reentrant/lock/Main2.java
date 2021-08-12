package org.example.juc.lesson3.reentrant.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lifei
 */
public class Main2 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " 外层");
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " 内层");
                } finally {
                    // lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }, "AA").start();
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 外层");
            lock.unlock();
        }, "BB").start();
    }
}
