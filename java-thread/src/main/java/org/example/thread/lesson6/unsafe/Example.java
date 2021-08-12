package org.example.thread.lesson6.unsafe;

/**
 * @author lifei
 */
public class Example {
    private int cnt = 0;

    public void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }
}
