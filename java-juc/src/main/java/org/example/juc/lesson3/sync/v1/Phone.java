package org.example.juc.lesson3.sync.v1;

/**
 * @author lifei
 */
public class Phone {
    public synchronized void sendSms() {
        System.out.println("sendSms");
    }

    public synchronized void sendEmail() {
        System.out.println("sendEmail");
    }

    public void sayHello() {
        System.out.println("sayHello");
    }
}
