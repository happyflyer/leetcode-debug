package org.example.lang.syntax;

/**
 * @author lifei
 */
public class TryCatchFinally {
    public int test1() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
        } finally {
            a = 40;
        }
        return a;
    }

    public int test2() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
        } finally {
            a = 40;
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(new TryCatchFinally().test1());
        System.out.println(new TryCatchFinally().test2());
    }
}
