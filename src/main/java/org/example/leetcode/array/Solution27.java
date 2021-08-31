package org.example.leetcode.array;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution27 {
    /**
     * 双指针。
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int low = 0;
        int high = n - 1;
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
        return low;
    }

    /**
     * 双指针。
     */
    public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast < n) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution27().removeElement2(
                        new int[]{0, 1, 2, 2, 3, 0, 4, 2},
                        2
                )
        );
    }
}
