package org.example.leetcode.array;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution26 {
    /**
     * 双指针。
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = 1;
        while (high < nums.length) {
            if (nums[high] != nums[low]) {
                // 当元素都不重复时，赋值操作就没有必要
                if (high > low + 1) {
                    nums[low + 1] = nums[high];
                }
                low++;
            }
            high++;
        }
        return low + 1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(
                new Solution26().removeDuplicates(ints)
        );
    }
}
