package org.example.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution53 {
    /**
     * 动态规划。
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
                        new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}
                )
        );
    }
}
