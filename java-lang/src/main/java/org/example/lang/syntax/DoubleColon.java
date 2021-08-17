package org.example.lang.syntax;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * https://zhuanlan.zhihu.com/p/266804576
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
