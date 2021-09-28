package org.example.algo.pointer2.removal;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new Solution27().removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}
