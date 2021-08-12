package org.example.thread.lesson5;

/**
 * @author lifei
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i > 3) {
                    try {
                        mainThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " 线程，i=" + i);
            }
        });
        thread.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " 线程，i=" + i);
        }
    }
}
