package org.example.leetcode.lang.ref;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * <p>
 * 当 JVM 进行垃圾回收时，
 * 如果内存空间足够，垃圾回收器就不会回收它；
 * 如果内存空间不足了，就会回收这些对象的内存。
 * 用来实现内存敏感的高速缓存,比如网页缓存、图片缓存等。
 *
 * @author lifei
 */
public class SoftRefTest {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj);
        SoftReference<Object> ref = new SoftReference<>(obj);
        System.out.println(ref.get());
        obj = null;
        System.out.println(ref.get());
        System.gc();
        System.out.println(ref.get());
    }
}
