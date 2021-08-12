package org.example.juc.lesson3.reentrant.sync;

/**
 * @author lifei
 */
public class Main2 {
    public synchronized void add() {
        add();
    }

    public static void main(String[] args) {
        new Main2().add();
    }
}
