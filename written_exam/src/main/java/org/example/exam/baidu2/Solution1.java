package org.example.exam.baidu2;

import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 2 2
 * 0 1
 * 1 0
 * 输出：
 * 0 0 1 1
 * 0 0 1 1
 * 1 1 0 0
 * 1 1 0 0
 * 说明：
 * <p>
 * 输入：
 * 3 3
 * 1 0 1
 * 0 0 0
 * 1 0 1
 * 输出：
 * 1 1 1 0 0 0 1 1 1
 * 1 1 1 0 0 0 1 1 1
 * 1 1 1 0 0 0 1 1 1
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 1 1 1 0 0 0 1 1 1
 * 1 1 1 0 0 0 1 1 1
 * 1 1 1 0 0 0 1 1 1
 * 说明：
 *
 * @author lifei
 */
public class Solution1 {
    public static int[][] getAns(int n, int k, int[][] mat) {
        int[][] res = new int[n * k][n * k];
        for (int i = 0; i < n * k; i++) {
            for (int j = 0; j < n * k; j++) {
                res[i][j] = mat[i / k][j / k];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        // int n = 2;
        // int k = 2;
        // int[][] mat = new int[][]{
        //         {0, 1},
        //         {1, 0}
        // };
        // int n = 3;
        // int k = 3;
        // int[][] mat = new int[][]{
        //         {1, 0, 1},
        //         {0, 0, 0},
        //         {1, 0, 1}
        // };
        int[][] res = getAns(n, k, mat);
        for (int i = 0; i < n * k; i++) {
            for (int j = 0; j < n * k; j++) {
                System.out.print(res[i][j]);
                if (j < n * k - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
