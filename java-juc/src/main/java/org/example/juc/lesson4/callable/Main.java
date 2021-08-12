package org.example.juc.lesson4.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new MyCallable());
        new Thread(task, "BB").start();
        System.out.println("call方法的返回值是：" + task.get());
    }
}
