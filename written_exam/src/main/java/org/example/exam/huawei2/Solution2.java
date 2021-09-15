package org.example.exam.huawei2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 10 3
 * 2 3 5 7 8 9
 * 输出：
 * 0
 * 说明：
 * 输入：
 * 5 5
 * 1 10 5 4 3 2 7 6 8 -1
 * 输出：
 * 10 5 8 7 6 4 3 2 1 -1
 * 输入：
 * 1 3
 * 2 4 6 8 10 12
 * 输出：
 * 12 10 8 6 4 2
 * 通过：
 *
 * @author lifei
 */
public class Solution2 {
    public static void getAns(int averageScore, int n, int[] nums) {
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int averageScore = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n * 2];
        int i = 0;
        while (i < n * 2) {
            nums[i] = sc.nextInt();
            i++;
        }
        getAns(averageScore, n, nums);
        System.out.println(0);
    }
}
