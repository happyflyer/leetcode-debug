package org.example.juc.lesson8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lifei
 */
public class Main1 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 办理业务");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            threadPool.shutdown();
        }
    }
}
