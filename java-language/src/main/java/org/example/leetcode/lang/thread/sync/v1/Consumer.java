package org.example.leetcode.lang.thread.sync.version1;

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
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(message.getTitle() + ": " + message.getContent());
        }
    }
}
