package org.example.leetcode.lang.juc.sync.v3;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();
        Thread.sleep(100);
        new Thread(() -> {
            phone.sayHello();
        }, "BB").start();
    }
}
