package org.example.exam.pdd3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 5
 * 1 3 5 2 4
 * 3
 * 4 2 7
 * 输出：
 * 2
 * 2
 * 3
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution1 {
    public static int[] getAns(int n, int[] a, int m, int[] b) {
        int[] ans = new int[m];
        int[] tmp = new int[n];
        tmp[0] = a[0];
        for (int i = 1; i < n; i++) {
            tmp[i] = tmp[i - 1] + a[i];
        }
        int[] nums = new int[10000000 + 9];
        Arrays.fill(nums, 0, tmp[0] + 1, 1);
        for (int i = 1; i < n; i++) {
            Arrays.fill(nums, tmp[i - 1] + 1, tmp[i] + 1, i + 1);
        }
        for (int i = 0; i < m; i++) {
            ans[i] = nums[b[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        int[] ans = getAns(n, a, m, b);
        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }
    }
}
