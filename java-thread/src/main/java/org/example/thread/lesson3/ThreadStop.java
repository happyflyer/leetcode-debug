package org.example.thread.lesson3;

/**
 * @author lifei
 */
public class ThreadStop {
    private static boolean flag = true;
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + num++);
            }
        }).start();
        Thread.sleep(100);
        flag = false;
    }
}
