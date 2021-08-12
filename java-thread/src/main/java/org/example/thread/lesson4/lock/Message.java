package org.example.thread.lesson4.lock;

/**
 * @author lifei
 */
public class Message {
    private String title;
    private String content;

    public synchronized void set(String title, String message) {
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = message;
    }

    public synchronized String get() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.title + ": " + this.content;
    }
}
