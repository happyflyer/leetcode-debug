package org.example.exam.shopee2;

/**
 * 输入：24,[8,3,12,7,9,7]
 * 输出：0
 *
 * @author lifei
 */
public class Solution1 {
    public int bestFit(int V, int[] item) {
        int n = item.length;
        int[] visited = new int[n];
        int[] max = new int[1];
        for (int i = 0; i < n; i++) {
            dfs(item, n, V, visited, i, 0, max);
        }
        return V - max[0];
    }

    private void dfs(int[] item, int n, int V, int[] visited,
                     int pos, int sum, int[] max) {
        if (sum > V) {
            return;
        }
        max[0] = Math.max(max[0], sum);
        if (max[0] == V) {
            return;
        }
        if (visited[pos] == 1) {
            return;
        }
        visited[pos] = 1;
        for (int i = 0; i < n; i++) {
            dfs(item, n, V, visited, i, sum + item[pos], max);
        }
        visited[pos] = 0;
    }

    public static void main(String[] args) {
        int V = 24;
        int[] item = new int[]{8, 3, 12, 7, 9, 7};
        System.out.println(new Solution1().bestFit(V, item));
    }
}
