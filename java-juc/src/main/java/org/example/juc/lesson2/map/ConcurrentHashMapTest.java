package org.example.juc.lesson2.map;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lifei
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 20; i++) {
            String key = String.valueOf(i);
            new Thread(() -> {
                map.put(key, UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + " :: " + map);
            }, String.valueOf(i + 1)).start();
        }
    }
}
