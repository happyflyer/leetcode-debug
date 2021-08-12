package org.example.thread.lesson3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lifei
 */
public class ExecutorShutdown {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable task = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executorService.execute(task);
        executorService.shutdownNow();
        System.out.println(Thread.currentThread().getName() +
                " 线程中断 " + task + " 线程");
    }
}
