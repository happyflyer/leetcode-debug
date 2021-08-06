package org.example.leetcode.lang.juc.lock2.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lifei
 */
public class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void write(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + " 正在写操作 " + key);
        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + " 写完 " + key);
    }

    public Object read(String key) {
        Object result;
        System.out.println(Thread.currentThread().getName() + " 正在读取 " + key);
        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = map.get(key);
        System.out.println(Thread.currentThread().getName() + " 读出 " + key);
        return result;
    }
}
