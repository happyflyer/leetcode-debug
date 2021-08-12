package org.example.thread.lesson2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lifei
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        // ExecutorService executorService = Executors.newFixedThreadPool(2);
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
