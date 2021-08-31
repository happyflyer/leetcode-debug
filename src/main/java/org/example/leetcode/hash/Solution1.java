package org.example.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution1().twoSum(new int[]{2, 7, 11, 15}, 9)
                )
        );
    }
}
