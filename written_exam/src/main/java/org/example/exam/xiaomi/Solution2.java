package org.example.exam.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 给你一个仅有红，白，蓝三种颜色组成的10个条块序列，
 * 现需要你将这些条块按照红，白，蓝的顺序排好，可用1代表红色，2代表白色，3代表蓝色，
 * 要求时间复杂度为O(n)。例如，给定彩色条块序列为：
 * ｛蓝、白、红、白、蓝、红、白、白、红、蓝｝
 * 则要求排列结果为：
 * ｛红、红、红、白、白、白、白、蓝、蓝、蓝｝
 * 输入：
 * 3 2 1 2 3 1 2 2 1 3
 * 输出：
 * 1 1 1 2 2 2 2 3 3 3
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution2 {
    public static String getAns(String s) {
        String[] sp = s.split(" ");
        int n = sp.length;
        System.out.println(n);
        System.out.println(Arrays.toString(sp));
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sp[i]);
        }
        int cur = 0;
        int begin = 0;
        int end = n - 1;
        while (cur < end) {
            if (arr[cur] == 1) {
                swap(arr, cur, begin);
                begin++;
                cur++;
            } else if (arr[cur] == 3) {
                swap(arr, cur, end);
                end--;
            } else {
                cur++;
            }
        }
        // Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String s = sc.nextLine();
        String s = "3 2 1 2 3 1 2 2 1 3";
        // String s = "1 2 3 2 1";
        System.out.println(getAns(s));
    }
}
