package org.example.juc.lesson5;

import java.util.concurrent.CountDownLatch;

/**
 * @author lifei
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 号同学离开了教室。");
                count.countDown();
            }, String.valueOf(i + 1)).start();
        }
        count.await();
        System.out.println(Thread.currentThread().getName() + " 班长要锁门走人了。");
    }
}
