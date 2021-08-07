package org.example.leetcode.lang.thread.sync.v1;

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
    }
}
