package org.example.lang.ref;

/**
 * https://blog.csdn.net/linzhiqiang0316/article/details/88591907
 * <p>
 * 强引用
 * <p>
 * 强引用有引用变量指向时永远不会被垃圾回收，
 * JVM 宁愿抛出 OutOfMemory 错误也不会回收这种对象。
 *
 * @author lifei
 */
public class StrongRefTest {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj);
        Object[] arr = new Object[1000];
        System.out.println(arr);
    }
}
