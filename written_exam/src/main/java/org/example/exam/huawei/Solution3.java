package org.example.exam.huawei;

import java.util.Scanner;

/**
 * 输入：
 * 输出：
 *
 * @author lifei
 */
public class Solution3 {
    public static int getAns(int m, int n, int[][] mat) {
        int[][] marked = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 陆地-1
                // 石头-2
                // 湖泊从1开始递增
                if (mat[i][j] == 1) {
                    marked[i][j] = -1;
                } else if (mat[i][j] == 2) {
                    marked[i][j] = -2;
                } else {
                    mark(m, n, mat, i, j, autoLakeId, marked);
                    autoLakeId++;
                }
            }
        }
        // System.out.println(Arrays.deepToString(marked));
        // 检查是否所有湖泊都连通
        // 检查本身<0，周围的湖泊编号都不相同，联通，更新湖泊号为最小的湖泊号
        return 0;
    }

    private static int autoLakeId = 1;

    private static void mark(int m, int n, int[][] mat,
                             int i, int j, int lakeId,
                             int[][] marked) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return;
        }
        if (mat[i][j] != 0) {
            return;
        }
        if (marked[i][j] != 0) {
            return;
        }
        marked[i][j] = lakeId;
        mark(m, n, mat, i - 1, j, lakeId, marked);
        mark(m, n, mat, i + 1, j, lakeId, marked);
        mark(m, n, mat, i, j - 1, lakeId, marked);
        mark(m, n, mat, i, j + 1, lakeId, marked);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        // int m = 5;
        // int n = 4;
        // int[][] mat = new int[][]{
        //         {0, 1, 1, 0},
        //         {0, 1, 0, 0},
        //         {0, 1, 0, 0},
        //         {0, 1, 0, 1},
        //         {1, 1, 1, 1}
        // };

        // int m = 3;
        // int n = 4;
        // int[][] mat = new int[][]{
        //         {0, 1, 0, 1},
        //         {1, 0, 2, 0},
        //         {0, 1, 0, 0}
        // };
        System.out.println(getAns(m, n, mat));
    }
}
