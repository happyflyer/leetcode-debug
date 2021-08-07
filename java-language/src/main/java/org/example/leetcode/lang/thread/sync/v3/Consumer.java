package org.example.leetcode.lang.thread.sync.v3;

/**
 * @author lifei
 */
public class Consumer implements Runnable {
    private final Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println(message.get());
        }
    }
}
