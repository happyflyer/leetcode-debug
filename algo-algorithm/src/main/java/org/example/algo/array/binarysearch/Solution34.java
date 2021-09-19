package org.example.algo.array.binarysearch;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        // return new int[]{
        //         left_bound_close(nums, target),
        //         right_bound_close(nums, target)
        // };
        return new int[]{
                left_bound_open(nums, target),
                right_bound_open(nums, target)
        };
    }

    int left_bound_open(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        // 搜索区间为[left,right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 搜索区间变为[left,mid)
                right = mid;
            } else if (nums[mid] < target) {
                // 搜索区间变为[mid+1,right)
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left,mid)
                right = mid;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int left_bound_close(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间为[left,right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 搜索区间变为[left,mid-1]
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 搜索区间变为[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left,mid-1]
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int right_bound_open(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        // 搜索区间为[left,right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 搜索区间变为[mid+1,right)
                left = mid + 1;
            } else if (nums[mid] < target) {
                // 搜索区间变为[mid+1,right)
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left,mid)
                right = mid;
            }
        }
        if (right <= 0 || nums[right - 1] != target) {
            return -1;
        }
        return right - 1;
    }

    int right_bound_close(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间为[left,right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 搜索区间变为[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] < target) {
                // 搜索区间变为[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left,mid-1]
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        System.out.println(Arrays.toString(new Solution34().searchRange(nums, target)));
    }
}
