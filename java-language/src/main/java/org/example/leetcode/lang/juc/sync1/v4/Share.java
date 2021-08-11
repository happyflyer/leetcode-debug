package org.example.leetcode.lang.juc.sync1.v4;

/**
 * @author lifei
 */
public class Share {
    private int number = 0;

    public synchronized void incr() throws InterruptedException {
        while (number != 0) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()
                + " :: " + ++number);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        while (number != 1) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()
                + " :: " + --number);
        this.notifyAll();
    }
}
