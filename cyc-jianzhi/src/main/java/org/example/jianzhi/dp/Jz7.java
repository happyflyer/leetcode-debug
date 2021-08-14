package org.example.jianzhi.dp;

/**
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160
 *
 * @author lifei
 */
public class Jz7 {
    /**
     * 递归
     */
    public int Fibonacci(int n) {
        System.out.println(n);
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 2) + Fibonacci(n - 1);
    }

    int[] cache;

    public int Fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        return fab(n);
    }

    /**
     * 递归加速
     */
    private int fab(int n) {
        if (n == 0) {
            return 0;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        cache[n] = fab(n - 2) + fab(n - 1);
        return cache[n];
    }

    /**
     * 递推
     */
    public int Fibonacci3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 2] + cache[i - 1];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz7().Fibonacci2(10)
        );
    }
}
