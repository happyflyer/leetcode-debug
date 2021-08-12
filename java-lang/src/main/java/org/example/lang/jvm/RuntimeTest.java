package org.example.lang.jvm;

/**
 * @author lifei
 */
public class RuntimeTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
        String s = "";
        for (int i = 0; i < 30000; i++) {
            s += i;
        }
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
        runtime.gc();
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
    }
}
