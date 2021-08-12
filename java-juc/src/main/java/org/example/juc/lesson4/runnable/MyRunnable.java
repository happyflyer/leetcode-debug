package org.example.juc.lesson4.runnable;

/**
 * @author lifei
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run");
    }
}
