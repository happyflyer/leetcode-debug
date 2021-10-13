package org.example.algo.dp.lesson1;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution322 {
    /**
     * 暴力递归。
     */
    public int coinChange1(int[] coins, int amount) {
        return dp1(coins, amount);
    }

    private int dp1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的解
            int subProblem = dp1(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) {
                continue;
            }
            // 在子问题中选择最优解，并且+1
            ans = Math.min(ans, subProblem + 1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 带备忘录的递归。
     */
    public int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        // 备忘录全部初始化为特殊值
        Arrays.fill(memo, -666);
        return dp2(memo, coins, amount);
    }

    private int dp2(int[] memo, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        // 查备忘录，防止重复计算
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp2(memo, coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            ans = Math.min(ans, subProblem + 1);
        }
        // 计算结果存入备忘录
        memo[amount] = ans == Integer.MAX_VALUE ? -1 : ans;
        return memo[amount];
    }

    /**
     * 迭代解法。
     */
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // dp 数组全部初始化为 amount + 1
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                // 状态转移方程
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution322().coinChange3(new int[]{2}, 3));
    }
}
