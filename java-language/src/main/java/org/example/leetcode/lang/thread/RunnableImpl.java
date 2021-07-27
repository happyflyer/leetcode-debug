package org.example.leetcode.lang.thread;

/**
 * @author lifei
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程执行");
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableImpl()).start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程执行");
        }
    }
}
