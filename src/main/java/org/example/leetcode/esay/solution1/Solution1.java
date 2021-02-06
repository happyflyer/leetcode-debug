package org.example.leetcode.esay.solution1;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author lifei
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // 双层循环
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(1)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
