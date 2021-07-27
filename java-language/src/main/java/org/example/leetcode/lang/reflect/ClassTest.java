package org.example.leetcode.lang.reflect;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassTest classTest = new ClassTest();
        System.out.println(classTest.getClass());
        System.out.println(classTest.getClass().getName());
        System.out.println(classTest.getClass().getClass());
        System.out.println(ClassTest.class);
        System.out.println(Class.forName("org.example.leetcode.lang.reflect.ClassTest"));
    }
}
