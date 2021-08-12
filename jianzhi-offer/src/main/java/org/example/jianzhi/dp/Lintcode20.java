package org.example.jianzhi.dp;

import java.util.*;

/**
 * https://www.lintcode.com/problem/20/
 *
 * @author lifei
 */
public class Lintcode20 {
    /**
     * 动态规划。
     * 使用一个二维数组 dp 存储点数出现的次数，
     * 其中 dp[i][j] 表示前 i 个骰子产生点数 j 的次数。
     * n = 1
     * [1, 2, 3, 4, 5, 6]
     * [1, 1, 1, 1, 1, 1]
     * n = 2
     * [1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12]
     * [0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1]
     * n = 3
     * [1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18]
     * [...]
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int max = face * n;
        long[][] dp = new long[n + 1][max + 1];
        for (int i = 1; i <= face; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= max; j++) {
                for (int k = 1; k <= face && k < j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        final double count = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ans = new ArrayList<>();
        for (int i = n; i < dp[n].length; i++) {
            ans.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / count));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Lintcode20().dicesSum(3)
        );
    }
}
