package org.example.exam.wangyigame;

import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 2
 * 8 11 2
 * 5 4
 * 6 3
 * 8 6
 * 6 2
 * 5 7
 * 3 4
 * 2 4
 * 5 2
 * 2 1
 * 3 1
 * 2 8
 * 8 4
 * 1 4
 * 9 8 7
 * 5 3
 * 7 3
 * 7 8
 * 9 8
 * 2 6
 * 6 8
 * 1 4
 * 4 3
 * 5 7
 * 9 2
 * 2 1
 * 4 8
 * 3 5
 * 6 1
 * 2 8
 * 输出：
 * 1
 * 1
 * 说明：
 * 通过：0
 *
 * @author lifei
 */
public class Solution2 {
    public static int getAns(int n,
                             int m1, int[] pathU, int[] pathV,
                             int m2, int[] doorU, int[] doorV) {
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while (i < t) {
            int n = sc.nextInt();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int[] pathU = new int[m1];
            int[] pathV = new int[m1];
            int j = 0;
            while (j < m1) {
                pathU[j] = sc.nextInt();
                pathV[j] = sc.nextInt();
                j++;
            }
            int[] doorU = new int[m2];
            int[] doorV = new int[m2];
            int k = 0;
            while (k < m2) {
                doorU[k] = sc.nextInt();
                doorV[k] = sc.nextInt();
                k++;
            }
            System.out.println(getAns(n, m1, pathU, pathV, m2, doorU, doorV));
            i++;
        }
    }
}
