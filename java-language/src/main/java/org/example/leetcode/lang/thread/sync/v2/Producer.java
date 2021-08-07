package org.example.leetcode.lang.thread.sync.v2;

/**
 * @author lifei
 */
public class Producer implements Runnable {
    private final Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            if (x % 2 == 0) {
                message.set("title-1", "content-1");
            } else {
                message.set("title-2", "content-2");
            }
        }
    }
}
