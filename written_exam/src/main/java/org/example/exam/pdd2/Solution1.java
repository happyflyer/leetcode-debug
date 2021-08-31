package org.example.exam.pdd2;

import java.util.Scanner;

/**
 * 数字消除。
 * <p>
 * 输入：
 * 1
 * 3 4 1
 * 5 2 3
 * 1 2 9 7
 * 输出：
 * 2
 *
 * @author lifei
 */
public class Solution1 {
    public static int getAns(int n, int m, int k, int[] a, int[] b) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while (i < t) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int x = 0;
            while (x < n) {
                a[x] = sc.nextInt();
                x++;
            }
            int[] b = new int[m];
            int y = 0;
            while (y < m) {
                b[y] = sc.nextInt();
                y++;
            }
            System.out.println(getAns(n, m, k, a, b));
            i++;
        }
    }
}
