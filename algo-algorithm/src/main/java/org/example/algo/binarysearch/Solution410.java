package org.example.algo.binarysearch;

/**
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution410 {
    /**
     * 普通遍历。
     */
    public int splitArray(int[] nums, int m) {
        int low = getMax(nums);
        int high = getSum(nums);
        for (int max = low; max <= high; max++) {
            int n = split(nums, max);
            if (n <= m) {
                return max;
            }
        }
        return -1;
    }

    public int splitArrayBinarySearch(int[] nums, int m) {
        int low = getMax(nums);
        int high = getSum(nums) + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int n = split(nums, mid);
            // if (n == m) {
            //     high = mid;
            // } else if (n < m) {
            //     high = mid;
            // } else if (n > m) {
            //     low = mid + 1;
            // }
            if (n <= m) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 在每个子数组和不超过 max 的条件下，
     * 计算 nums 至少可以分割成几个子数组。
     */
    private int split(int[] nums, int max) {
        int count = 1;
        int sum = 0;
        for (int n : nums) {
            if (sum + n > max) {
                count++;
                sum = n;
            } else {
                sum += n;
            }
        }
        return count;
    }

    private int getMax(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = Math.max(res, n);
        }
        return res;
    }

    private int getSum(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res += n;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
