package org.example.exam.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列的长度。
 * 如果最长公共子序列为空，则返回"0"。目前给出的数据，仅仅会存在一个最长的公共子序列
 * 输入：
 * 1A2C3D4E56
 * A1B2345C6D
 * 输出：
 * 6
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution1 {
    public static int getAns(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        // String str1 = "1A2C3D4E56";
        // String str2 = "A1B2345C6D";
        System.out.println(getAns(str1, str2));
    }
}
