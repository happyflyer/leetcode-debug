package org.example.leetcode.lang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lifei
 */
public class CallableImpl implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程执行");
        }
        return Thread.currentThread().getName() + " 线程执行完毕";
    }

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new CallableImpl());
        new Thread(task).start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程执行");
        }
        System.out.println(task.get());
    }
}
