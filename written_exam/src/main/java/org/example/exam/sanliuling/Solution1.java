package org.example.exam.sanliuling;

import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 5
 * 5 1 2 1 5
 * 输出：
 * 3
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution1 {
    public static int getAns(int n, int[] nums) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= nums[j + 1]) {
                    break;
                }
                count++;
            }
            for (int j = i + 1; j < n; j++) {
                if (nums[j] >= nums[j - 1]) {
                    break;
                }
                count++;
            }
            ans = Math.max(ans, count);
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
        // int n = 5;
        // int[] nums = new int[]{5, 1, 2, 1, 5};
        System.out.println(getAns(n, nums));
    }
}
