package org.example.leetcode.lang.juc.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author lifei
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            String key = String.valueOf(i);
            new Thread(() -> {
                map.put(key, UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + " :: " + map);
            }, String.valueOf(i + 1)).start();
        }
    }
}
