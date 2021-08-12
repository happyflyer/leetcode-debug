package org.example.thread.lesson5.notify;

/**
 * @author lifei
 */
public class Message {
    private String title;
    private String content;
    private boolean has = false;

    public synchronized void set(String title, String message) {
        while (has) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = message;
        has = true;
        notifyAll();
    }

    public synchronized String get() {
        while (!has) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return this.title + ": " + this.content;
        } finally {
            has = false;
            notifyAll();
        }
    }
}
