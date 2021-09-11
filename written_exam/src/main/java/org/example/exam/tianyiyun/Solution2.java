package org.example.exam.tianyiyun;

import java.util.Scanner;

/**
 * 题目描述：用1、5、10、20、50、100，装满N的组合个数。
 * 输入：1
 * 输出：1
 * 说明：
 * 输入：0
 * 输出：0
 * 通过：AC
 *
 * @author lifei
 */
public class Solution2 {
    public static long getAns(int n) {
        if (n == 0) {
            return 0;
        }
        int[] cup = new int[]{1, 5, 10, 20, 50, 100};
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int j = 0; j < 6; j++) {
            for (int i = cup[j]; i <= n; i++) {
                dp[i] += dp[i - cup[j]];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getAns(n));
    }
}
