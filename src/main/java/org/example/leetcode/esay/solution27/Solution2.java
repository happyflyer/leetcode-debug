package org.example.leetcode.esay.solution27;

/**
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author lifei
 */
public class Solution2 {
    public int removeElement(int[] nums, int val) {
        // 定义两个指针，一个慢指针i，一个快指针j
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
