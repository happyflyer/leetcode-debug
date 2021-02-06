package org.example.leetcode.esay.solution26;

/**
 * 26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author lifei
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 不能使用额外的数组空间，因此只能使用双指针的办法
        // 把不重复的元素移动到数组最前面
        // 一个指针（p）记录结果，一个指针（q）遍历原数组
        // p从0开始，q从1开始
        // 因为是有序的，所以每次只需要比较p指向的元素（结果中最大的元素）和q指向的元素是否相同
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[q] != nums[p]) {
                // nums[p+1] = nums[q];
                // 当元素都不重复时，赋值操作就没有必要
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
