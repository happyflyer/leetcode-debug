package org.example.exam.xiaohongshu;

import java.util.Scanner;

/**
 * 小红书校园招聘，某个部门恰好招聘了N*N位（N<=150）同学，
 * 为了让大家快速融入大家庭，我们玩儿了一个快速记人和问题速答的游戏，
 * 开始是每个人的自我介绍，然后介绍自己的家乡特点和爱好，之后是问题提问，
 * 每个人会被问到多个关于另一个同学相关的问题，答对加一分，打错负一分，
 * 在所有问答环节结束之后，HR统计在这些同学中，
 * 哪个子矩阵区域的同学总分最高，并对这个区域的同学进行鼓励。
 * <p>
 * 输入：
 * 3
 * 1 2 -3 3 4 -5 -5 -6 -7
 * 输出：
 * 10
 * 说明：
 * 1  2 -3
 * 3  4 -5
 * -5 -6 -7
 * <p>
 * ac
 *
 * @author lifei
 */
public class Solution1 {
    public static int getAns(int n, int[][] matrix) {
        if (n == 0) {
            return 0;
        }
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            tmp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < n; k++) {
                tmp[i][k] = tmp[i - 1][k] + matrix[i][k];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int[] b = new int[n];
        // 开始行
        for (int i = 0; i < n; i++) {
            // 结束行
            for (int j = i; j < n; j++) {
                int curSum = 0;
                for (int k = 0; k < n; k++) {
                    if (i == 0) {
                        b[k] = tmp[j][k];
                    } else {
                        b[k] = tmp[j][k] - tmp[i - 1][k];
                    }
                    curSum = Math.max(b[k], b[k] + curSum);
                    maxSum = Math.max(maxSum, curSum);
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(getAns(n, matrix));
    }
}
