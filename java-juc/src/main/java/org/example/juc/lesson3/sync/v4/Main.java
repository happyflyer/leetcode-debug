package org.example.juc.lesson3.sync.v4;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            try {
                phone1.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();
        Thread.sleep(100);
        new Thread(() -> {
            phone2.sendEmail();
        }, "BB").start();
    }
}
