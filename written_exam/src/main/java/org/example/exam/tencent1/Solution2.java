package org.example.exam.tencent1;

import java.util.Scanner;

/**
 * 输入：
 * 2
 * 3
 * 1 1 1
 * 2
 * 1 2
 * 输出：
 * 7
 * 5
 *
 * @author lifei
 */
public class Solution2 {
    static int count;

    public static int getCount(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            dfs(arr, n, new int[n], i, 0, new int[n]);
        }
        return count;
    }

    public static void dfs(int[] arr, int n, int[] visited, int cur,
                           int depth, int[] path) {
        if (depth == n) {
            int sum = 0;
            for (int i : path) {
                sum += i;
            }
            count = Math.max(count, sum);
            return;
        }
        if (visited[cur] == 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[cur] = 1;
            path[depth] = arr[cur];
            dfs(cloneAndAdd(arr, arr[cur]), n, visited, i, depth + 1, path);
            path[depth] = 0;
            visited[cur] = 0;
        }
    }

    public static int[] cloneAndAdd(int[] arr, int val) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i] + val;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while (i < t) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int j = 0;
            while (j < n) {
                arr[j] = sc.nextInt();
                j++;
            }
            count = Integer.MIN_VALUE;
            System.out.println(getCount(arr));
            i++;
        }
    }
}
