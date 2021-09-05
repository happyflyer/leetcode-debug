package org.example.exam.tencent2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入：
 * 4
 * 1 3 1 2
 * 输出：
 * 4
 * <p>
 * 输入：
 * 4
 * 1 1 2 1
 * 输出：
 * 5
 * <p>
 * 输入：
 * 7
 * 1 4 2 5 7 1 3
 * 输出：
 * 10
 * <p>
 * 10.00%
 *
 * @author lifei
 */
public class Solution5 {
    public static int getAns(int n, int[] arr) {
        int[][] dp = new int[n][n];
        for (int low = 0; low < n - 1; low++) {
            dp[low][low + 1] = 1;
            for (int high = low + 2; high < n; high++) {
                if (dp[low][high - 1] == 1
                        && arr[high - 1] >= arr[low]
                        && arr[high - 1] >= arr[high]) {
                    dp[low][high] = 1;
                } else {
                    dp[low][high] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        int sum = 0;
        for (int low = 0; low < n - 1; low++) {
            for (int high = low + 1; high < n; high++) {
                sum += dp[low][high];
            }
        }
        return sum;
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
        // int n = 4;
        // int[] arr = new int[]{1, 3, 1, 2};
        int n = 4;
        int[] arr = new int[]{1, 1, 2, 1};
        System.out.println(getAns(n, arr));
    }
}
