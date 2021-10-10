package org.example.exam.kedaxunfei2;

import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 4
 * 1 2 1 2
 * 输出：
 * 2
 * 输入：
 * 9
 * 1 1 1 2 3 3 3 4 3
 * 输出：
 * 4
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution2 {
    /**
     * 滑动窗口。
     */
    public static int getAns(int n, int[] a) {
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            while (a[right] != a[left]) {
                max = Math.max(max, right - left);
                left = right;
            }
            right++;
        }
        return max;
    }

    public static int getAns2(int n, int[] a) {
        // 可以交换的次数
        int count = 1;
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            // 如果不相等，且可以交换
            if (a[right] != a[left] && count > 0) {
                // 注意right的取值
                if (right < n - 1 && a[left] == a[right + 1]) {
                    swap(a, right, right + 1);
                    count--;
                }
            }
            while (a[right] != a[left]) {
                max = Math.max(max, right - left);
                left = right;
            }
            right++;
        }
        return max;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] a = new int[n];
        // for (int i = 0; i < n; i++) {
        //     a[i] = sc.nextInt();
        // }
        // int n = 4;
        // int[] a = new int[]{1, 2, 1, 2};
        int n = 9;
        int[] a = new int[]{1, 1, 1, 2, 3, 3, 3, 4, 3};
        System.out.println(getAns(n, a));
        System.out.println(getAns2(n, a));
    }
}
