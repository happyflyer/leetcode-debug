package org.example.algo.custom.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution380 {
    class RandomizedSet {
        LinkedList<Integer> nums;
        Map<Integer, Integer> valToIndex;

        public RandomizedSet() {
            nums = new LinkedList<>();
            valToIndex = new HashMap<>();
        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }
            valToIndex.put(val, nums.size());
            nums.addLast(val);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) {
                return false;
            }
            int index = valToIndex.get(val);
            valToIndex.put(nums.get(nums.size() - 1), index);
            swap(nums, index, nums.size() - 1);
            nums.removeLast();
            valToIndex.remove(val);
            return true;
        }

        private void swap(LinkedList<Integer> nums, int i, int j) {
            Integer temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }

        public int getRandom() {
            return nums.get(new Random().nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {
    }
}
