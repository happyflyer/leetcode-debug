package org.example.thread.lesson4.lock;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(() -> {
            for (int x = 0; x < 10; x++) {
                if (x % 2 == 0) {
                    message.set("title-1", "content-1");
                } else {
                    message.set("title-2", "content-2");
                }
            }
        }, "producer").start();
        new Thread(() -> {
            for (int x = 0; x < 10; x++) {
                System.out.println(message.get());
            }
        }, "consumer").start();
    }
}
