package org.example.exam.sanliuling;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 3
 * 4 1 8
 * 输出：
 * 0
 * 说明：
 * 输入：
 * 8
 * 6 6 6 6 2 3 3 3
 * 输出：
 * 9
 * 通过：36
 *
 * @author lifei
 */
public class Solution2 {
    public static int getAns(int n, int[] nums) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += makeYeah(n, nums, i);
            System.out.println(Arrays.toString(nums));
        }
        return ans;
    }

    public static int makeYeah(int n, int[] nums, int pos) {
        int count = 0;
        if (pos == 0 || pos == n - 1) {
            return 0;
        }
        int target = Math.max(nums[pos - 1], nums[pos + 1]);
        if (nums[pos] < target) {
            return count;
        }
        count += (nums[pos] - (target - 1));
        nums[pos] = target - 1;
        if (nums[pos - 1] >= nums[pos]) {
            count += makeYeah(n, nums, pos - 1);
        }
        if (nums[pos + 1] >= nums[pos]) {
            count += makeYeah(n, nums, pos + 1);
        }
        return count;
    }

    public static int getAns2(int n, int[] nums) {
        int ans = 0;
        int left = 0;
        int right = n - 1;
        while (left + 1 < right) {
            // System.out.println("left = " + left + ", right = " + right);
            int leftVal = nums[left];
            int rightVal = nums[right];
            if (leftVal >= rightVal) {
                if (nums[left + 1] > leftVal - 1) {
                    ans += (nums[left + 1] - (leftVal - 1));
                    nums[left + 1] = leftVal - 1;
                }
                left++;
            } else {
                if (nums[right - 1] > rightVal - 1) {
                    ans += (nums[right - 1] - (rightVal - 1));
                    nums[right - 1] = rightVal - 1;
                }
                right--;
            }
            // System.out.println(Arrays.toString(nums));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // int n = 3;
        // int[] nums = new int[]{4, 1, 8};
        // int n = 8;
        // int[] nums = new int[]{6, 6, 6, 6, 2, 3, 3, 3};
        // int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(getAns2(n, nums));
    }
}
