package org.example.leetcode.lang.juc.lock2.v2;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 0; i < 5; i++) {
            int finalI = i + 1;
            String key = String.valueOf(finalI);
            new Thread(() -> {
                cache.write(key, key);
            }, "write-" + (i + 1)).start();
        }
        for (int i = 0; i < 5; i++) {
            int finalI = i + 1;
            String key = String.valueOf(finalI);
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()
                        + " 读出的数据是 " + key + " : " + cache.read(key));
            }, "read-" + (i + 1)).start();
        }
    }
}
