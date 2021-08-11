package org.example.leetcode.lang.juc.sync1.v1;

/**
 * @author lifei
 */
public class Ticket {
    private int number = 30;

    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName()
                    + "卖出一张票，剩下：" + --number);
        }
    }
}
