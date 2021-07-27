package org.example.leetcode.lang.thread;

/**
 * @author lifei
 */
public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(new Thread().getPriority());
        Runnable run = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 线程，i=" + i);
            }
        };
        Thread thread1 = new Thread(run, "thread-1");
        Thread thread2 = new Thread(run, "thread-2");
        Thread thread3 = new Thread(run, "thread-3");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
