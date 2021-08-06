package org.example.leetcode.lang.juc.sync.v2;

import java.util.concurrent.TimeUnit;

/**
 * @author lifei
 */
public class Phone {
    public synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendSms");
    }

    public synchronized void sendEmail() {
        System.out.println("sendEmail");
    }

    public void sayHello() {
        System.out.println("sayHello");
    }
}
