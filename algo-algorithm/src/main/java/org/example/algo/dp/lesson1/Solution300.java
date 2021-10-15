package org.example.algo.dp.lesson1;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution300 {
    /**
     * 动态规划。
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // base case
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 二分查找。
     * 从左向右一张一张处理牌，最终要将这些牌分成若干堆。
     * 只能把点数小的牌压到点数比它大的牌上；
     * 如果当前牌点数较大没有可以放置的堆，则新建一个堆，把这张牌放进去；
     * 如果当前牌有多个堆可供选择，则选择最左边的那一堆放置。
     * 牌的堆数就是最长递增子序列的长度。
     */
    public int lengthOfLISBinarySearch(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }

    public static void main(String[] args) {
        System.out.println(new Solution300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
