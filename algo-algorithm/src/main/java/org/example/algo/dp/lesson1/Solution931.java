package org.example.algo.dp.lesson1;

/**
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] cost = new int[n][n];
        // base case
        System.arraycopy(matrix[0], 0, cost[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 状态转移方程
                int upLeft = j > 0 ? cost[i - 1][j - 1] : Integer.MAX_VALUE;
                int up = cost[i - 1][j];
                int upRight = j < n - 1 ? cost[i - 1][j + 1] : Integer.MAX_VALUE;
                cost[i][j] = Math.min(Math.min(upLeft, upRight), up) + matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, cost[n - 1][i]);
        }
        return min;
    }

    /**
     * 空间优化。
     */
    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int[][] cost = new int[2][n + 2];
        cost[0][0] = Integer.MAX_VALUE;
        cost[1][0] = Integer.MAX_VALUE;
        cost[0][n + 1] = Integer.MAX_VALUE;
        cost[1][n + 1] = Integer.MAX_VALUE;
        // base case
        System.arraycopy(matrix[0], 0, cost[0], 1, n);
        for (int i = 1; i < n; i++) {
            int line = i % 2;
            for (int j = 1; j <= n; j++) {
                // 状态转移方程
                int upLeft = cost[1 - line][j - 1];
                int up = cost[1 - line][j];
                int upRight = cost[1 - line][j + 1];
                cost[line][j] = Math.min(Math.min(upLeft, upRight), up) + matrix[i][j - 1];
            }
        }
        int min = Integer.MAX_VALUE;
        int line = (n - 1) % 2;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, cost[line][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution931().minFallingPathSum2(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
    }
}
