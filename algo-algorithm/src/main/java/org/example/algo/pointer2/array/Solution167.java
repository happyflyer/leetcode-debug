package org.example.algo.pointer2.array;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
    }
}
