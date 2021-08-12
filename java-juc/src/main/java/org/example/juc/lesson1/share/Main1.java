package org.example.juc.lesson1.share;

import org.example.juc.lesson1.share.sync.Share1;

/**
 * @author lifei
 */
public class Main1 {
    public static void main(String[] args) {
        Share1 share = new Share1();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }
}
