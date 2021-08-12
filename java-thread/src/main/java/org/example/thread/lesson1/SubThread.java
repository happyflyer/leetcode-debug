package org.example.thread.lesson1;

/**
 * @author lifei
 */
public class SubThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程执行");
        }
    }

    public static void main(String[] args) {
        new SubThread().start();
        // new SubThread().run();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 线程执行");
        }
    }
}
