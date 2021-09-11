package org.example.exam.tianyiyun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：三色球排序。leetcode 75。
 * 输入：6 2 0 2 1 1 0
 * 输出：0 0 1 1 2 2
 * 说明：
 * 通过：80%
 *
 * @author lifei
 */
public class Solution3 {
    public static void getAns(int n, int[] arr) {
        // Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        for (int i = 0; i <= end; i++) {
            while (i <= end && arr[i] == 2) {
                int tmp = arr[i];
                arr[i] = arr[end];
                arr[end] = tmp;
                --end;
            }
            if (arr[i] == 0) {
                int tmp = arr[i];
                arr[i] = arr[start];
                arr[start] = tmp;
                ++start;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // int i = 0;
        // while (i < n) {
        //     arr[i] = sc.nextInt();
        //     i++;
        // }
        int n = 6;
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
        getAns(n, arr);
        for (int j = 0; j < n; j++) {
            if (j > 0) {
                System.out.print(" ");
            }
            System.out.print(arr[j]);
        }
    }
}
