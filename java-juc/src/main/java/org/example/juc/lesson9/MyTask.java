package org.example.juc.lesson9;

import java.util.concurrent.RecursiveTask;

/**
 * @author lifei
 */
public class MyTask extends RecursiveTask<Integer> {
    private static final Integer VALUE = 10;
    private final int begin;
    private final int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - begin) <= VALUE) {
            for (int i = begin; i <= end; i++) {
                result += i;
                System.out.println(Thread.currentThread().getName()
                        + " add " + i + ", result = " + result);
            }
        } else {
            int mid = (begin + end) / 2;
            MyTask myTask1 = new MyTask(begin, mid);
            MyTask myTask2 = new MyTask(mid + 1, end);
            myTask1.fork();
            myTask2.fork();
            result += (myTask1.join() + myTask2.join());
        }
        return result;
    }
}
