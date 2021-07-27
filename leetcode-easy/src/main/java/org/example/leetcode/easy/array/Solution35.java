package org.example.leetcode.easy.array;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author lifei
 */
public class Solution35 {
    /**
     * 二分查找
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid;
        int ans = n;
        while (low <= high) {
            mid = (high + low) >> 1;
            if (target <= nums[mid]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution35().searchInsert(
                        new int[]{1, 3, 5, 6},
                        7
                )
        );
    }
}
