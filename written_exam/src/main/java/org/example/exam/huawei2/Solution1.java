package org.example.exam.huawei2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 1 3 5
 * 2
 * 输出：
 * 3
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution1 {
    public static boolean judge(int mid, int[] a, int[] b) {
        int n1 = a.length;
        int cover = 0;
        for (int x : b) {
            while (cover < n1 && a[cover] <= x + mid && a[cover] >= x - mid) {
                cover += 1;
            }
            if (cover == n1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] stemp1 = input.nextLine().split(" ");
        int[] workstations = new int[stemp1.length];
        for (int i = 0; i < stemp1.length; i++) {
            workstations[i] = Integer.parseInt(stemp1[i]);
        }
        String[] stemp2 = input.nextLine().split(" ");
        int[] sterilizers = new int[stemp2.length];
        for (int i = 0; i < stemp2.length; i++) {
            sterilizers[i] = Integer.parseInt(stemp2[i]);
        }
        Arrays.sort(workstations);
        Arrays.sort(sterilizers);
        int left = 1;
        int right = Integer.parseInt("1000000005");
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (judge(mid, workstations, sterilizers)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
