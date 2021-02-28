package org.example.leetcode.normal.solution16;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * @author lifei
 */
public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 10000000;
        int first;
        int second;
        int third;
        int cur;
        for (first = 0; first < n; ++first) {
            second = first + 1;
            third = n - 1;
            while (second < third) {
                cur = nums[first] + nums[second] + nums[third];
                if (Math.abs(target - cur) < Math.abs(target - ans)) {
                    ans = cur;
                }
                if (cur > target) {
                    --third;
                } else {
                    ++second;
                }
            }
        }
        return ans;
    }
}
