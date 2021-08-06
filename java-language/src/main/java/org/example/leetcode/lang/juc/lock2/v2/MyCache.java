package org.example.leetcode.lang.juc.lock2.v2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：
 * 一个资源可以被多个读线程访问，或者可以被一个写线程访问，
 * 但是，不能存在同时读写线程。
 * 写写互斥，读写互斥，读读共享。
 * <p>
 * 读写锁的缺点：造成锁饥饿。
 * 1、一直读，不能写。
 * 2、一直写，不让读。
 *
 * @author lifei
 */
public class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void write(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在写操作 " + key);
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写完 " + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public Object read(String key) {
        rwLock.readLock().lock();
        try {
            Object result;
            System.out.println(Thread.currentThread().getName() + " 正在读取 " + key);
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读出 " + key);
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
        return null;
    }
}
