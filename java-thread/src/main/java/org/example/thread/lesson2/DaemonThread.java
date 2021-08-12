package org.example.thread.lesson2;

/**
 * @author lifei
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " i=" + i);
            }
        }, "userThread");
        Thread daemonThread = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " i=" + i);
            }
        }, "daemonThread");
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
    }
}
