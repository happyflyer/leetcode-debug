package org.example.thread.lesson7.threadlocal;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + " 获取到的值是 " + threadLocal.get());
            threadLocal.remove();
        }, "AA").start();
        new Thread(() -> {
            threadLocal.set(2);
            System.out.println(Thread.currentThread().getName()
                    + " 获取到的值是 " + threadLocal.get());
            threadLocal.remove();
        }, "BB").start();
    }
}
