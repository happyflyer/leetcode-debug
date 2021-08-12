package org.example.thread.lesson6.safe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lifei
 */
public class Example {
    private AtomicInteger cnt = new AtomicInteger();

    public void add() {
        cnt.incrementAndGet();
    }

    public int get() {
        return cnt.get();
    }
}
