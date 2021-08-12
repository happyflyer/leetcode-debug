package org.example.juc.lesson3.sync.v1;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSms();
        }, "AA").start();
        Thread.sleep(100);
        new Thread(() -> {
            phone.sendEmail();
        }, "BB").start();
    }
}
