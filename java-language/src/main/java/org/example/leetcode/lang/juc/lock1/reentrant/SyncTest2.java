package org.example.leetcode.lang.juc.lock1.reentrant;

/**
 * @author lifei
 */
public class SyncTest2 {
    public synchronized void add() {
        add();
    }

    public static void main(String[] args) {
        new SyncTest2().add();
    }
}
