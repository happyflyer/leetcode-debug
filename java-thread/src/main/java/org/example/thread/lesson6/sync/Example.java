package org.example.thread.lesson6.sync;

/**
 * @author lifei
 */
public class Example {
    private int cnt = 0;

    public synchronized void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }
}
