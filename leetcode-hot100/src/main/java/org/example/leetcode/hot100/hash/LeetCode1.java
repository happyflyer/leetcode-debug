package org.example.leetcode.hot100.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author lifei
 */
public class LeetCode1 {
    /**
     * 数组，哈希表
     */
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
                        new LeetCode1().twoSum(new int[]{2, 7, 11, 15}, 9)
                )
        );
    }
}
