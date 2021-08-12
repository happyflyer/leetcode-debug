package org.example.lang.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 * <p>
 * 不影响对象的生命周期。
 * 如果一个对象与虚引用关联，则跟没有引用与之关联一样，
 * 在任何时候都可能被垃圾回收器回收。
 *
 * @author lifei
 */
public class PhantomRefTest {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj);
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> ref = new PhantomReference<>(obj, queue);
        System.out.println(ref.get());
        obj = null;
        System.out.println(ref.get());
        System.gc();
        System.out.println(ref.get());
    }
}
