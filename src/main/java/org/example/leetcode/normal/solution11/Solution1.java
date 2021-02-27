package org.example.leetcode.normal.solution11;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author lifei
 */
public class Solution1 {
    public int maxArea(int[] height) {
        // 双指针
        int low = 0;
        int high = height.length - 1;
        int ans = 0;
        int curArea;
        while (low < high) {
            curArea = Math.min(height[low], height[high]) * (high - low);
            ans = Math.max(ans, curArea);
            if (height[low] <= height[high]) {
                ++low;
            } else {
                --high;
            }
        }
        return ans;
    }
}
