package org.example.thread.lesson3;

/**
 * @author lifei
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程开始执行");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 线程被中断");
            }
            System.out.println(Thread.currentThread().getName() + " 线程结束");
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println(Thread.currentThread().getName() +
                " 线程中断 " + thread.getName() + " 线程");
    }
}
