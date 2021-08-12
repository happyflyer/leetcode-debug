package org.example.juc.lesson9;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(1, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        System.out.println(forkJoinTask.get());
    }
}
