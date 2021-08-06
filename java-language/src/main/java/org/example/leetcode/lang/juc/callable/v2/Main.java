package org.example.leetcode.lang.juc.callable.v2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " call");
            Thread.sleep(10);
            return 1024;
        });
        new Thread(task, "AA").start();
        while (!task.isDone()) {
            System.out.println(Thread.currentThread().getName() + " wait...");
        }
        System.out.println("call方法的返回值是：" + task.get());
        System.out.println("call方法的返回值是：" + task.get());
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
}
