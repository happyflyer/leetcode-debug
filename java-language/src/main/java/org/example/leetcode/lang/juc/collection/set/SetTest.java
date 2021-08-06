package org.example.leetcode.lang.juc.collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author lifei
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + " :: " + set);
            }, String.valueOf(i + 1)).start();
        }
    }
}
