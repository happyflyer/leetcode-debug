package org.example.algo.binarysearch;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution704 {
    /**
     * 闭区间。
     */
    public int search_close(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间为[left,right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 搜索区间变为[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left,mid-1]
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 开区间。
     */
    public int search_open(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        // 搜索区间为[left,right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 搜索区间变为[mid+1,right)
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left,mid)
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
