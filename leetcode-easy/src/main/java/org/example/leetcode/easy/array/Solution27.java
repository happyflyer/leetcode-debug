package org.example.leetcode.easy.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author lifei
 */
public class Solution27 {
    /**
     * 双指针
     * <p>
     * low 从前往后，high 从后往前，
     * 1、如果 num[low]==val，
     * 1.1、如果 num[high]!=val，num[high]->num[low]，low 后移一位，high 前移一位，
     * 1.2、如果 num[high]==val，high 前移一位，
     * 2、如果 num[low]!=val，low 后移一位，
     * 在 low<=high 做上述操作。
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] == val) {
                if (nums[high] != val) {
                    nums[low] = nums[high];
                    low++;
                }
                high--;
            } else {
                low++;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(nums, low)));
        return low;
    }

    /**
     * 双指针
     * <p>
     * 一个慢指针 slow，一个快指针 fast
     */
    public int removeElement2(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(Arrays.copyOf(nums, slow)));
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution27().removeElement2(
                        new int[]{3, 2, 2, 3},
                        3
                )
        );
    }
}
