package org.example.leetcode.lang.juc.sync.v6;

import java.util.concurrent.TimeUnit;

/**
 * @author lifei
 */
public class Phone {
    public static synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendSms");
    }

    public static synchronized void sendEmail() {
        System.out.println("sendEmail");
    }

    public void sayHello() {
        System.out.println("sayHello");
    }
}
