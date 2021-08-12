package org.example.thread.lesson1;

/**
 * @author lifei
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程执行");
        }
    }

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程执行");
        }
    }
}
