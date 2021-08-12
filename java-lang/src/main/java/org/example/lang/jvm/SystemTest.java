package org.example.lang.jvm;

/**
 * @author lifei
 */
public class SystemTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 30000; i++) {
            s += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.gc();
        start = end;
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
