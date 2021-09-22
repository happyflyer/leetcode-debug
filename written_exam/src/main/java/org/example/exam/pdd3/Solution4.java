package org.example.exam.pdd3;

import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 2
 * 3 4 3 3
 * 1 2 3
 * 1 1
 * 1 3
 * 2 2
 * 3 1
 * 0 1 1 1
 * 1 1
 * 输出：
 * 2 1
 * 2 2
 * 2 1
 * 3 1
 * 1 1
 * 说明：
 * 通过：0
 *
 * @author lifei
 */
public class Solution4 {
    public static int[][] getAns(int n, int m, int x, int y,
                                 int[] arr, int[][] pq) {
        int[][] ans = new int[m][];
        int[][] cups = new int[][]{{0, 0}, {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int i = 0; i < m; i++) {
            int x0 = pq[i][0];
            int y0 = pq[i][1];
            for (int j = 0; j < n; j++) {
                int row = cups[arr[j]][0];
                int col = cups[arr[j]][1];
                if (row == -1 && x0 == 1) {
                    continue;
                }
                if (row == 1 && x0 == x) {
                    continue;
                }
                if (col == -1 && y0 == 1) {
                    continue;
                }
                if (col == -1 && y0 == y) {
                    continue;
                }
                x0 += row;
                y0 += col;
            }
            ans[i][0] = x0;
            ans[i][1] = y0;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while (i < t) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            int[][] pq = new int[m][];
            for (int j = 0; j < m; j++) {
                pq[j][0] = sc.nextInt();
                pq[j][1] = sc.nextInt();
            }
            i++;
        }
    }
}
