package org.example.reflect;

/**
 * @author lifei
 */
public class HelloClass {
    public static void main(String[] args) throws ClassNotFoundException {
        HelloClass obj = new HelloClass();
        // 对象名.getClass()
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getName());
        System.out.println(obj.getClass().getSimpleName());
        System.out.println(obj.getClass().getPackage());
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(obj.getClass().getClass());
        // 类名.class
        System.out.println(HelloClass.class);
        // Class.forName("类的全路径名")
        System.out.println(Class.forName("org.example.reflect.HelloClass"));
    }
}
