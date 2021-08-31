package org.example.leetcode.array;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution11 {
    /**
     * 双指针。
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int curArea;
        int low = 0;
        int high = height.length - 1;
        while (low < high) {
            curArea = Math.min(height[low], height[high]) * (high - low);
            maxArea = Math.max(curArea, maxArea);
            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution11().maxArea(
                        new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}
                )
        );
    }
}
