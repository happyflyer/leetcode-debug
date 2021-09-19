package org.example.exam.wangyileihuo;

import java.util.*;

/**
 * 题目描述：
 * 输入：
 * 3 3
 * 1 2 4 8 6
 * 2 0 5 1 7
 * 3 4 0 0 8
 * 4 5 0 3 1
 * 5 0 0 4 2
 * 6 7 1 9 0
 * 7 0 2 6 0
 * 8 1 3 0 9
 * 9 6 8 0 0
 * 输出：
 * 5 4 3
 * 2 1 8
 * 7 6 9
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution1 {
    public static int[][] getAns(int n, int m,
                                 int[] ids,
                                 int[] xs, int[] ys,
                                 int[] zs, int[] ws) {
        int size = n * m;
        int[][] ans = new int[n][m];
        for (int i = 0; i < size; i++) {
            if (xs[i] == 0 && ys[i] == 0) {
                ans[0][0] = ids[i];
                break;
            }
        }
        Map<Integer, Integer> leftToRight = new HashMap<>();
        for (int i = 0; i < size; i++) {
            leftToRight.put(xs[i], ids[i]);
        }
        Map<Integer, Integer> upToDown = new HashMap<>();
        for (int i = 0; i < size; i++) {
            upToDown.put(ys[i], ids[i]);
        }
        // 从第二列开始，第一行从左向右
        for (int i = 1; i < m; i++) {
            ans[0][i] = leftToRight.get(ans[0][i - 1]);
        }
        // 从第二行开始，从上向下
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                ans[i][j] = upToDown.get(ans[i - 1][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ids = new int[n * m];
        int[] xs = new int[n * m];
        int[] ys = new int[n * m];
        int[] zs = new int[n * m];
        int[] ws = new int[n * m];
        int i = 0;
        while (i < n * m) {
            ids[i] = sc.nextInt();
            xs[i] = sc.nextInt();
            ys[i] = sc.nextInt();
            zs[i] = sc.nextInt();
            ws[i] = sc.nextInt();
            i++;
        }
        int[][] ans = getAns(n, m, ids, xs, ys, zs, ws);
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (k > 0) {
                    System.out.print(" ");
                }
                System.out.print(ans[j][k]);
            }
            System.out.println();
        }
    }
}
