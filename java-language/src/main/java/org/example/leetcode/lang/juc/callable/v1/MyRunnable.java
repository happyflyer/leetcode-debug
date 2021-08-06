package org.example.leetcode.lang.juc.callable.v1;

/**
 * @author lifei
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run");
    }
}
