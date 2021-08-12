package org.example.exam.shangtang;

import java.util.Arrays;

/**
 * 不能采集相邻两块地中的药材。最多采集的药材。
 * <p>
 * 输入：[1]
 * 输出：0
 * <p>
 * 输入：[3,4]
 * 输出：4
 * <p>
 * 输入：[]
 * 输出：0
 * <p>
 * 输入：[3,6,2,3,10]
 * 输出：16
 *
 * @author lifei
 */
public class Solution3 {
    int max = 0;

    public int pick(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return max;
        }
        dfs(nums, n, new int[n], 0, new int[n]);
        return max;
    }

    /**
     * 深度优先搜索，回溯
     */
    private void dfs(int[] nums, int n, int[] visited, int depth, int[] path) {
        System.out.println();
        System.out.println("depth = " + depth);
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("visited = " + Arrays.toString(visited));
        System.out.println("path = " + Arrays.toString(path));
        if (allVisited(visited)) {
            int sum = 0;
            for (int i = 0; i < depth; i++) {
                sum += path[i];
            }
            max = Math.max(max, sum);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                int prevVisitedBackup = i > 0 ? visited[i - 1] : 0;
                int nextVisitedBackup = i < n - 1 ? visited[i + 1] : 0;
                if (prevVisitedBackup != 2 && nextVisitedBackup != 2) {
                    visited[i] = 2;
                    if (i > 0) {
                        visited[i - 1] = 1;
                    }
                    if (i < n - 1) {
                        visited[i + 1] = 1;
                    }
                    path[depth] = nums[i];
                    dfs(nums, n, visited, depth + 1, path);
                    visited[i] = 0;
                    if (i > 0) {
                        visited[i - 1] = prevVisitedBackup;
                    }
                    if (i < n - 1) {
                        visited[i + 1] = nextVisitedBackup;
                    }
                }
            }
        }
    }

    private boolean allVisited(int[] visited) {
        for (int i : visited) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                // new Solution3().pick(new int[]{3, 6, 2, 3, 10})
                // new Solution3().pick(new int[]{})
                // new Solution3().pick(new int[]{1})
                // new Solution3().pick(new int[]{3, 4})
                // new Solution3().pick(new int[]{2, 3, 4})
                // new Solution3().pick(new int[]{1, 0, 1})
                // new Solution3().pick(new int[]{1, 1, 0})
                // new Solution3().pick(new int[]{1, 1, 1, 1})
                // new Solution3().pick(new int[]{1, 1, 1, 1, 1})
                // new Solution3().pick(new int[]{1, 1, 1, 1, 1, 1})
                new Solution3().pick(new int[]{1, 1, 1, 1, 1, 3, 1})
        );
    }
}
