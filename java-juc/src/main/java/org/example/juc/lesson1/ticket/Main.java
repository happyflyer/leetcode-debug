package org.example.juc.lesson1.ticket;

import org.example.juc.lesson1.ticket.sync.Ticket;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();
    }
}
