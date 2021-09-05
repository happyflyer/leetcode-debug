package org.example.exam.tencent1;

import java.util.Scanner;

/**
 * 输入：
 * 1
 * 3 10
 * 3 6 9
 * 输出：
 * 3
 * <p>
 * 输入：
 * 2
 * 6 5
 * 1 2 5 4 1 2
 * 10 6
 * 1 2 2 1 3 3 2 3 1 5
 * 输出：
 * 4
 * 6
 *
 * @author lifei
 */
public class Solution3 {
    public static int getCount(int n, int w, int[] arr) {
        int count = 0;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while (i < t) {
            int n = sc.nextInt();
            int w = sc.nextInt();
            int[] arr = new int[n];
            int j = 0;
            while (j < n) {
                arr[j] = sc.nextInt();
                j++;
            }
            getCount(n, w, arr);
            i++;
        }
    }
}
