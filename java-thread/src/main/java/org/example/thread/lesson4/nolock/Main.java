package org.example.thread.lesson4.nolock;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(() -> {
            for (int x = 0; x < 10; x++) {
                if (x % 2 == 0) {
                    message.setTitle("title-1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    message.setContent("content-1");
                } else {
                    message.setTitle("title-2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    message.setContent("content-2");
                }
            }
        }, "producer").start();
        new Thread(() -> {
            for (int x = 0; x < 10; x++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(message.getTitle() + ": " + message.getContent());
            }
        }, "consumer").start();
    }
}
