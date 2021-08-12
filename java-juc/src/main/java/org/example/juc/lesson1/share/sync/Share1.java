package org.example.juc.lesson1.share.sync;

/**
 * @author lifei
 */
public class Share1 {
    private int number = 0;

    public synchronized void incr() throws InterruptedException {
        if (number != 0) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()
                + " :: " + ++number);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        if (number != 1) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()
                + " :: " + --number);
        this.notifyAll();
    }
}
