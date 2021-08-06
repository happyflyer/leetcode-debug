package org.example.leetcode.lang.juc.utils.cyc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lifei
 */
public class Main {
    private static final int NUMBER = 7;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7, () -> {
            System.out.println("7颗龙珠已集齐");
            System.out.println("召唤神龙");
        });
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 龙珠找到");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i + 1)).start();
        }
    }
}
