package org.example.leetcode.lang.juc.utils.semaphone;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    long start = System.currentTimeMillis();
                    System.out.println(Thread.currentThread().getName() + " 抢到了车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    long end = System.currentTimeMillis();
                    System.out.println(Thread.currentThread().getName()
                            + " 离开了车位，占用车位时长：" + (end - start));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i + 1)).start();
        }
    }
}
