package org.example.reflect;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author lifei
 */
public class UnsafeTest {
    private UnsafeTest() {
        System.out.println("UnsafeTest 私有构造方法执行");
    }

    public static void main(String[] args) {
        try {
            // 获得 unsafe 对象
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            // 绕过 JVM 对象管理机制，使用构造方法创建实例化对象
            UnsafeTest unsafeTest = (UnsafeTest) unsafe.allocateInstance(UnsafeTest.class);
            System.out.println(unsafeTest);
        } catch (NoSuchFieldException
                | IllegalAccessException
                | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
