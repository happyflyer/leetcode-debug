package org.example.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * https://www.cnblogs.com/yougewe/p/10125073.html
 *
 * @author lifei
 */
public class HelloReflect {
    public void sayHello(String word) {
        System.out.println("hello, " + word);
    }

    public static void main(String[] args) {
        try {
            // 1. 使用外部配置的实现，进行动态加载类
            Class<?> clazz = Class.forName("org.example.reflect.HelloReflect");
            HelloReflect obj = (HelloReflect) clazz.newInstance();
            obj.sayHello("call directly");
            // 2. 根据配置的函数名，进行方法调用（不需要通用的接口抽象）
            Method method = obj.getClass().getDeclaredMethod("sayHello", String.class);
            method.invoke(obj, "method invoke");
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
