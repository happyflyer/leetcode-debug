package org.example.juc.lesson10;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        // 同步调用
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName()
                    + " : completableFuture1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        completableFuture1.get();
        // 异步调用，实际开发中使用：mq消息队列
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()
                    + " : completableFuture2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = 10 / 0;
            return 1024;
        });
        completableFuture2.whenComplete((t, u) -> {
            System.out.println("t : " + t);
            System.out.println("u : " + u);
        }).get();
    }
}
