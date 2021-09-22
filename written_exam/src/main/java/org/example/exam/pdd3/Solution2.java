package org.example.exam.pdd3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述：
 * 输入：
 * 3
 * 3 3 7
 * 1 1 2
 * 5 5 8
 * 3 9 7
 * 3 3 6
 * 10 9 6
 * 10 10 10
 * 1 7 4
 * 3 3 7
 * 1 4 9
 * 10 6 10
 * 3 3 5
 * 输出：
 * 1
 * 0
 * 4
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution2 {
    public static int getAns(int n, int m, int k, int[][] mat) {
        Set<Integer> set = new HashSet<>();
        int[] res = new int[1];
        if (mat[0][0] == mat[n - 1][m - 1]) {
            return res[0];
        }
        set.add(mat[0][0]);
        dfs(mat, n, m, 0, 0, set, res);
        return res[0];
    }

    private static void dfs(int[][] mat, int n, int m,
                            int x, int y,
                            Set<Integer> set,
                            int[] res) {
        if (x == n - 1 && y == m - 1) {
            res[0]++;
            return;
        }
        if (y < m - 1 && !set.contains(mat[x][y + 1])) {
            set.add(mat[x][y + 1]);
            dfs(mat, n, m, x, y + 1, set, res);
            set.remove(mat[x][y + 1]);
        }
        if (x < n - 1 && !set.contains(mat[x + 1][y])) {
            set.add(mat[x + 1][y]);
            dfs(mat, n, m, x + 1, y, set, res);
            set.remove(mat[x + 1][y]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while (i < t) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] mat = new int[n][m];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    mat[x][y] = sc.nextInt();
                }
            }
            System.out.println(getAns(n, m, k, mat));
            i++;
        }
    }
}
