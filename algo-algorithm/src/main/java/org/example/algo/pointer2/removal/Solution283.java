package org.example.algo.pointer2.removal;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int val = 0;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow] = val;
            slow++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new Solution283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
