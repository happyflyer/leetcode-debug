package org.example.leetcode.array.sum;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution16 {
    /**
     * 排序+双指针。
     */
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int a;
        int b;
        int c;
        int cur;
        for (a = 0; a < n; ++a) {
            b = a + 1;
            c = n - 1;
            while (b < c) {
                cur = nums[a] + nums[b] + nums[c];
                if (Math.abs(target - cur) < Math.abs(target - ans)) {
                    ans = cur;
                }
                if (cur > target) {
                    --c;
                } else {
                    ++b;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution16().threeSumClosest(
                        new int[]{-1, 2, 1, -4},
                        1
                )
        );
    }
}
