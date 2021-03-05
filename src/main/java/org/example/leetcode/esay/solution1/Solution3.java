package org.example.leetcode.esay.solution1;

import java.util.Arrays;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author lifei
 */
class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 2) {
            return new int[0];
        }
        int[] sorted = nums.clone();
        // 排序 + 双指针
        Arrays.sort(sorted);
        int low = 0;
        int high = n - 1;
        int cur;
        while (low < high) {
            cur = sorted[low] + sorted[high];
            if (cur == target) {
                break;
            }
            if (cur < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{
                findLowIndex(nums, sorted[low]),
                findHighIndex(nums, sorted[high])
        };
    }

    public int findLowIndex(int[] nums, int lowValue) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == lowValue) {
                return i;
            }
        }
        return 0;
    }

    public int findHighIndex(int[] nums, int highValue) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == highValue) {
                return i;
            }
        }
        return 0;
    }
}
