package org.example.algo.dp.lesson1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/target-sum/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution494 {
    public int findTargetSumWays1(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ans = new int[]{0};
        backtrack1(nums, target, 0, 0, ans);
        return ans[0];
    }

    /**
     * 回溯。
     */
    private void backtrack1(int[] nums, int target, int i, int sum, int[] ans) {
        // base case
        if (i == nums.length) {
            if (sum == target) {
                ans[0]++;
            }
            return;
        }
        // 选择+
        backtrack1(nums, target, i + 1, sum + nums[i], ans);
        // 选择-
        backtrack1(nums, target, i + 1, sum - nums[i], ans);
    }

    public int findTargetSumWays2(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ans = new int[]{0};
        backtrack2(nums, target, 0, ans);
        return ans[0];
    }

    /**
     * 回溯。
     */
    private void backtrack2(int[] nums, int rest, int i, int[] ans) {
        // base case
        if (i == nums.length) {
            if (rest == 0) {
                ans[0]++;
            }
            return;
        }
        // 选择+
        backtrack2(nums, rest - nums[i], i + 1, ans);
        // 选择-
        backtrack2(nums, rest + nums[i], i + 1, ans);
    }

    public int findTargetSumWays3(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        Map<String, Integer> memo = new HashMap<>();
        return dp(nums, target, 0, memo);
    }

    /**
     * 带备忘录的回溯。
     */
    private int dp(int[] nums, int rest, int i, Map<String, Integer> memo) {
        // base case
        if (i == nums.length) {
            if (rest == 0) {
                return 1;
            }
            return 0;
        }
        String key = i + "," + rest;
        // 查备忘录，避免重复计算
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 穷举
        int result = dp(nums, rest - nums[i], i + 1, memo)
                + dp(nums, rest + nums[i], i + 1, memo);
        // 存备忘录
        memo.put(key, result);
        return result;
    }

    /**
     * sum(A) - sum(B) = target
     * sum(A) = target + sum(B)
     * sum(A) + sum(A) = target + sum(B) + sum(A)
     * 2 * sum(A) = target + sum(nums)
     */
    public int findTargetSumWays4(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // target为负数时，与找-target的结果相同
        target = Math.abs(target);
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        return subset(nums, (sum + target) / 2);
    }

    /**
     * 动态规划。
     * 状态定义：
     * dp[i][j]表示若只在 nums 的前 i 个元素中选择，若目标和为 j，则最多有 x 种方法划分子集。
     * 初始值：
     * dp[0][..] = 0 表示没有元素时，没有方案。
     * dp[..][0] = 1 表示目标和是 0 时，只有一种方案（就是都不选）。
     * 状态转移：
     * dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
     * 表示 不选当前元素 和 选当前元素 的方案之和。
     */
    private int subset(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    // 两种选择状态之和
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    // 背包空间不足，只能选择不装物品i
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    /**
     * 状态压缩。
     */
    private int subset2(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        // base case
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println(new Solution494().findTargetSumWays4(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
