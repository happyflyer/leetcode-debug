package org.example.leetcode.easy.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author lifei
 */
public class Solution53 {
    /**
     * 暴力法
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int low = 0; low < n; low++) {
            for (int high = low; high < n; high++) {
                int i = low;
                int sum = 0;
                while (i <= high) {
                    sum += nums[i++];
                }
                System.out.println(
                        Arrays.toString(
                                Arrays.copyOfRange(nums, low, high + 1)
                        ) + ", sum=" + sum
                );
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    /**
     * 解答错误
     */
    public int maxSubArray2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println(Arrays.toString(nums) + ", sum=" + sum);
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        // 第一个元素<0 或 最后一个元素<0
        if (nums[0] <= 0 || nums[n - 1] <= 0) {
            if (nums[0] < nums[n - 1]) {
                return maxSubArray2(Arrays.copyOfRange(nums, 1, n));
            } else {
                return maxSubArray2(Arrays.copyOfRange(nums, 0, n - 1));
            }
        }
        sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 第一个元素>0 且 最后一个元素>0，第一个元素 < 最后一个元素
        if (nums[0] < nums[n - 1]) {
            return Math.max(sum, maxSubArray2(Arrays.copyOfRange(nums, 1, n)));
        } else {
            return Math.max(sum, maxSubArray2(Arrays.copyOfRange(nums, 0, n - 1)));
        }
    }

    /**
     * 动态规划
     */
    public int maxSubArray3(int[] nums) {
        int pre = 0;
        int maxSum = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution53().maxSubArray3(
                        // new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}
                        // new int[]{-1, -2}
                        new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4}
                )
        );
    }
}
