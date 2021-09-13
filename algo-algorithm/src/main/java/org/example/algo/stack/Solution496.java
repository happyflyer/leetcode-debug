package org.example.algo.stack;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution496 {
    /**
     * 单调栈模板。
     */
    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        int n2 = nums2.length;
        // 快速获取索引下标
        Map<Integer, Integer> map = new HashMap<>(n2);
        for (int i = 0; i < n2; i++) {
            map.put(nums2[i], i);
        }
        int[] list = nextGreaterElement(nums2);
        for (int i = 0; i < n; i++) {
            res[i] = list[map.get(nums1[i])];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 4, 3};
        System.out.println(
                Arrays.toString(
                        new Solution496().nextGreaterElement(nums)
                )
        );
    }
}
