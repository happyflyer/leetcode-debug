package org.example.leetcode.lang.juc.sync1.v6;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        Share share = new Share();
        Thread aa = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA");
        Thread bb = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB");
        Thread cc = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC");
        aa.start();
        bb.start();
        cc.start();
    }
}
