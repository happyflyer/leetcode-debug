package org.example.leetcode.esay.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author lifei
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        // 哈希表
        // 主要减少寻找target-nums[i]的时间
        // 设置哈希表的key为target-num[i]，value为i
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        int n = nums.length;
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }
}
