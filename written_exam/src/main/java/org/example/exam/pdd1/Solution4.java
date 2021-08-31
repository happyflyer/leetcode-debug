package org.example.exam.pdd1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 考试题目难度排序。
 * <p>
 * 输入：
 * 3 1
 * 1 2 3
 * 输出：
 * 4
 * 说明：
 * 123
 * 132
 * 213
 * 321
 * <p>
 * 输入：
 * 4 0
 * 1 2 2 3
 * 输出：
 * 2
 * 说明：
 * 1223
 * 1223
 *
 * @author lifei
 */
public class Solution4 {
    int count = 0;

    public int getPathCount(int n, int m, int[] array) {
        dfs(n, m, array, new int[n], 0, new int[n]);
        return count;
    }

    /**
     * 深度搜索，回溯
     */
    private void dfs(int n, int m, int[] array, int[] visited, int depth, int[] path) {
        if (depth == n) {
            System.out.println(Arrays.toString(path));
            count += 1;
            return;
        }
        for (int i = 0; i < n; i++) {
            // 没有访问过 且 上一题难度<=本题难度+m
            if (visited[i] == 0 && (depth == 0 || path[depth - 1] <= array[i] + m)) {
                visited[i] = 1;
                path[depth] = array[i];
                dfs(n, m, array, visited, depth + 1, path);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(new Solution4().getPathCount(n, m, array));
    }
}
