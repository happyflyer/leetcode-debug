package org.example.algo.array.twosum;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution170 {
    class TwoSum {
        Map<Integer, Integer> freq = new HashMap<>();

        /**
         * 向数据结构中添加一个数 number。
         * O(1)。
         */
        public void add(int number) {
            freq.put(number, freq.getOrDefault(number, 0) + 1);
        }

        /**
         * 寻找当前数据结构中是否存在两个数的和为 value。
         * O(N)，空间复杂度为 O(N)。
         */
        public boolean find(int value) {
            for (Integer key : freq.keySet()) {
                int other = value - key;
                // 情况一
                if (other == key && freq.get(key) > 1) {
                    return true;
                }
                // 情况二
                if (other != key && freq.containsKey(other)) {
                    return true;
                }
            }
            return false;
        }
    }

    class TwoSum2 {
        Set<Integer> sum = new HashSet<>();
        List<Integer> nums = new LinkedList<>();

        public void add(int number) {
            // 记录所有可能组成的和
            for (int n : nums) {
                sum.add(n + number);
            }
            nums.add(number);
        }

        public boolean find(int value) {
            return sum.contains(value);
        }
    }

    public static void main(String[] args) {
    }
}
