package org.example.exam.shenxinfu;

import java.util.Arrays;

/**
 * 输入：[1,2,3]
 * 输出：[2,2,-2]
 * <p>
 * 输入：[9, 3, 3, 6]
 * 输出：[0,6,6,-3]
 * <p>
 * ac
 *
 * @author lifei
 */
public class Solution1 {
    public int[] nearestDiff(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = i - 1;
            int left = 0;
            while (x >= 0) {
                if (nums[x] < nums[i]) {
                    left = nums[x];
                    break;
                }
                x--;
            }
            int y = i + 1;
            int right = 0;
            while (y < n) {
                if (nums[y] > nums[i]) {
                    right = nums[y];
                    break;
                }
                y++;
            }
            ans[i] = right - left;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution1().nearestDiff(new int[]{9, 3, 3, 6})
                )
        );
    }
}
