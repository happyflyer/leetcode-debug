package org.example.juc.lesson8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lifei
 */
public class Main3 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 100; i++) {
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
