package org.example.leetcode.esay.solution35;

/**
 * 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author lifei
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        // 二分查找
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid;
        int ans = n;
        while (left <= right) {
            mid = (right + left) >> 1;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
