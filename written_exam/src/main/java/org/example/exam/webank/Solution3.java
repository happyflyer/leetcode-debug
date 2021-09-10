package org.example.exam.webank;

import java.util.Scanner;

/**
 * 题目描述：序列解构。
 * 已知一个长度为n的序列A。我们求出了它的前缀序列，但是却不小心把它的原序列丢失了，
 * 请你从它的前缀序列中推出它的原序列，并输出出来。
 * 这里的前缀序列B定义为，B[i]为所有下标小于等于i中的元素中，所有奇数位置的和减去所有偶数位置的和。
 * A序列和B序列的下标均从1开始。
 * 输入：
 * 4
 * 1 -1 2 -2
 * 输出：
 * 1 2 3 4
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution3 {
    public static int[] getAns(int n, int[] B) {
        if (n == 1) {
            return new int[]{0};
        }
        int[] A = new int[n + 1];
        A[1] = B[1];
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                int tmp = evenSum + B[i];
                A[i] = tmp - oddSum;
                oddSum = tmp;
            } else {
                int tmp = oddSum - B[i];
                A[i] = tmp - evenSum;
                evenSum = tmp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] B = new int[n + 1];
        int i = 1;
        while (i <= n) {
            B[i] = sc.nextInt();
            i++;
        }
        // int n = 4;
        // int[] B = new int[]{0, 1, -1, 2, -2};
        int[] a = getAns(n, B);
        for (int j = 1; j <= n; j++) {
            if (j > 1) {
                System.out.print(" ");
            }
            System.out.print(a[j]);
        }
    }
}
