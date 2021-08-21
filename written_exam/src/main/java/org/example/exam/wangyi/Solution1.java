package org.example.exam.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数组中任何两个元素相加，小于。
 * <p>
 * 输入：
 * 7 -1 -1
 * 9
 * 输出：
 * 3
 *
 * @author lifei
 */
public class Solution1 {
    static int cnt = 0;

    public static int getCnt(int[] arr, int m) {
        int n = arr.length;
        dfs(arr, n, m, new int[n], 0, new int[2]);
        return cnt / 2;
    }

    private static void dfs(int[] arr, int n, int m, int[] visited,
                            int depth, int[] path) {
        if (depth == 2) {
            if (path[0] + path[1] <= m) {
                System.out.println("visited = " + Arrays.toString(visited));
                System.out.println("path = " + Arrays.toString(path));
                cnt++;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                path[depth] = arr[i];
                dfs(arr, n, m, visited, depth + 1, path);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int m = sc.nextInt();
        System.out.println(getCnt(arr, m));
    }
}
