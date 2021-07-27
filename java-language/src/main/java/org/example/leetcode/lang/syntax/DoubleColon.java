package org.example.leetcode.lang.syntax;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * https://zhuanlan.zhihu.com/p/266804576
 * <p>
 * 双冒号运算操作符是类方法的句柄，
 * lambda表达式的一种简写，这种简写的学名叫eta-conversion或者叫η-conversion。
 * <p>
 * 英文格式双冒号::，读：double colon，
 * 双冒号（::）运算符在 Java 8 中被用作方法引用（method reference），
 * 方法引用是与 lambda 表达式相关的一个重要特性。
 * 它提供了一种执行方法的方法，
 * 为此，方法引用需要由兼容的函数式接口组成的目标类型上下文。
 * <p>
 * 双冒号(::)使用场景一般有如下6种：
 * 引用静态方法，类名::静态方法名，Integer::parseInt
 * 引用特定对象实例方法，对象名::实例方法名，System.out::println
 * 引用特定类型的任意对象的实例方法，特定类型::示例方法名，String::compareToIgnoreCase
 * 引用超类（父类）实例方法，super::方法名
 * 引用类构造方法，类名::new，ArrayList::new
 * 引用数组构造方法，数组类型[]::new，String[]::new
 *
 * @author lifei
 */
public class DoubleColon {
    public static void staticPrint(String s) {
        System.out.println(s);
    }

    public void instancePrint(String s) {
        System.out.println(s);
    }

    public static class Father {
        public void print(String s) {
            System.out.println(s);
        }
    }

    public static class Son extends Father {
        public void print(List<String> list) {
            list.forEach(super::print);
        }
    }

    public static class Obj {
        private String name;
        private int age;

        public Obj() {
        }

        public Obj(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    interface ObjNoParam {
        Obj createObj();
    }

    interface ObjWithParam {
        Obj createObj(String name, int age);
    }

    @FunctionalInterface
    interface MyArrayFunction<A, T> {
        T apply(A a);
    }

    List<String> list;
    String[] arr;

    public DoubleColon() {
        list = Arrays.asList("c", "b", "a");
        arr = new String[]{"c", "b", "a"};
    }

    public void testStaticMethod() {
        list.forEach(DoubleColon::staticPrint);
    }

    public void testInstanceMethod() {
        list.forEach(new DoubleColon()::instancePrint);
    }

    public void testTypeMethod() {
        Arrays.sort(arr, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(arr));
    }

    public void testSuperMethod() {
        new DoubleColon.Son().print(list);
    }

    public void testConstructorMethod() {
        DoubleColon.ObjNoParam onp = DoubleColon.Obj::new;
        DoubleColon.Obj obj1 = onp.createObj();
        System.out.println(obj1);
        DoubleColon.ObjWithParam owp = DoubleColon.Obj::new;
        DoubleColon.Obj obj2 = owp.createObj("zhangsan", 23);
        System.out.println(obj2);
    }

    public void testArrayMethod() {
        Function<Integer, String[]> function = String[]::new;
        String[] arr = function.apply(5);
        System.out.println(Arrays.toString(arr));
    }

    public void testMyArrayMethod() {
        DoubleColon.MyArrayFunction<Integer, String[]> function = String[]::new;
        String[] arr = function.apply(5);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        DoubleColon colon = new DoubleColon();
        colon.testStaticMethod();
        colon.testInstanceMethod();
        colon.testTypeMethod();
        colon.testSuperMethod();
        colon.testConstructorMethod();
        colon.testArrayMethod();
        colon.testMyArrayMethod();
    }
}
