package org.example.juc.lesson4.runnable;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        new Thread(new MyRunnable(), "AA").start();
    }
}
