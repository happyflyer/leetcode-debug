package org.example.algo.dp.lesson1;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution509 {
    /**
     * 暴力递归。
     */
    public int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 带备忘录的递归。
     */
    public int fib2(int n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    private int dp(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        // 如果已经计算过了，就直接返回
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    /**
     * 迭代解法。
     */
    public int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // 状态转移方程
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 状态压缩。
     */
    public int fib4(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new Solution509().fib4(40));
    }
}
