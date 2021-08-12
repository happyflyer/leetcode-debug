package org.example.juc.lesson6.downgrade;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        writeLock.lock();
        System.out.println("写操作");
        // 锁降级
        readLock.lock();
        System.out.println("读取");
        writeLock.unlock();
        readLock.unlock();
    }
}
