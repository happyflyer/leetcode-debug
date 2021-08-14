package org.example.exam.tcl;

import java.util.ArrayList;
import java.util.List;

/**
 * 有四个数字：1、2、3、4，能组成多少个互不相同且无重复数字
 *
 * @author lifei
 */
public class Solution1 {
    public int getNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        dfs(nums, n, new int[n], list, 0, new int[n]);
        System.out.println(list);
        return list.size();
    }

    /**
     * 深度优先搜索，回溯
     */
    private void dfs(int[] nums, int n, int[] visited, List<Integer> list,
                     int depth, int[] path) {
        if (depth == n) {
            list.add(intArrayToInteger(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                path[depth] = nums[i];
                dfs(nums, n, visited, list, depth + 1, path);
                visited[i] = 0;
            }
        }
    }

    private int intArrayToInteger(int[] arr) {
        int ans = 0;
        for (int i : arr) {
            ans = ans * 10 + i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution1().getNumbers(new int[]{1, 2, 3, 4})
        );
    }
}
