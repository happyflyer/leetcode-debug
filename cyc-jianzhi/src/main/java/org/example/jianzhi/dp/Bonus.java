package org.example.jianzhi.dp;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/questionTerminal/72a99e28381a407991f2c96d8cb238ab
 *
 * @author lifei
 */
public class Bonus {
    /**
     * 动态规划。
     * dp[i,j] = max(dp[i-1,j], dp[i,j-1]) + board[i,j]
     */
    public int getMost(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] cache = new int[m][n];
        cache[0][0] = board[0][0];
        for (int i = 1; i < m; i++) {
            cache[i][0] = cache[i - 1][0] + board[i][0];
        }
        for (int j = 1; j < n; j++) {
            cache[0][j] = cache[0][j - 1] + board[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]) + board[i][j];
            }
        }
        System.out.println(Arrays.deepToString(cache));
        return cache[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(
                new Bonus().getMost(new int[][]{
                        {1, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18},
                        {19, 20, 21, 22, 23, 24},
                        {25, 26, 27, 28, 29, 30},
                        {31, 32, 33, 34, 35, 36}
                })
        );
    }
}
