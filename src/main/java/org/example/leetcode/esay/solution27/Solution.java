package org.example.leetcode.esay.solution27;

/**
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author lifei
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义两个指针，指针p从前往后，指针q从后往前
        // 如果p指向元素==val：
        // 如果q指向元素!=val，q指向元素->p指向元素，p后移一位，q前移一位
        // 如果q指向元素==val，q前移一位
        // 如果p指向元素!=val，p后移一位
        // 在p<=q做上述操作
        int p = 0;
        int q = nums.length - 1;
        while (p <= q) {
            if (nums[p] == val) {
                if (nums[q] != val) {
                    nums[p] = nums[q];
                    p++;
                }
                q--;
            } else {
                p++;
            }
        }
        return p;
    }
}
