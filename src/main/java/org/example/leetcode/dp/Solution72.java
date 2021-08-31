package org.example.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution72 {
    /**
     * 动态规划。
     * 定义dp[i, j] 为第一个字符串长度为i的子串到第二个字符串长度为j的子串之间的编辑距离
     * if i==0 && j==0, dp[i, j] = 0;
     * if i==0 && j>0, dp[i, j] = j;
     * if i>0 && j==0, dp[i, j] = i;
     * if i>0 && j>0, dp[i, j] = min(
     * dp[i - 1, j] + 1,
     * dp[i, j - 1] + 1,
     * dp[i - 1, j - 1] + f(i, j)
     * );
     * f(i, j) 表示第一个字符串的第i个字符不等于第二个字符串的第j个字符时，f(i, j) = 1，
     * 否则 f(i, j) = 0
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        int cost = 0;
        for (int i = 1; i <= m; i++) {
            char ci = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char cj = word2.charAt(j - 1);
                if (ci == cj) {
                    cost = 0;
                } else {
                    cost = 1;
                }
                dp[i][j] = Math.min(
                        dp[i - 1][j - 1] + cost,
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
                );
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution72().minDistance("intention", "execution")
        );
    }
}
