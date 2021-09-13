package org.example.algo.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 4, 3};
        System.out.println(
                Arrays.toString(
                        new Solution503().nextGreaterElements(nums)
                )
        );
    }
}
