package org.example.leetcode.lang.ref;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 * <p>
 * 当 JVM 进行垃圾回收时，
 * 无论内存是否充足，都会回收被弱引用关联的对象。
 * <p>
 * 但是，如果存在强引用同时与堆中对象关联，
 * 则进行垃圾回收时也不会回收该对象（软引用也是如此）。
 *
 * @author lifei
 */
public class WeakRefTest {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj);
        WeakReference<Object> ref = new WeakReference<>(obj);
        System.out.println(ref.get());
        obj = null;
        System.out.println(ref.get());
        System.gc();
        System.out.println(ref.get());
    }
}
