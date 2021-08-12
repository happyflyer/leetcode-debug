package org.example.exam.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 选择糖果的取法有多少种。
 * 输入：
 * n,t,c
 * 0,1,2,...,n-1
 * <p>
 * 输入：
 * 4 2 2
 * 1 2 3 1
 * 输出：
 * 1
 * 说明：
 * 12,1
 * <p>
 * 输入：
 * 4 2 2
 * 1 1 1 1
 * 输出：
 * 3
 * 说明：
 * 11,1,1
 * 1,11,1
 * 1,1,11
 *
 * @author lifei
 */
public class Solution2 {
    public int getTakeOutCount(int n, int t, int c, int[] array) {
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            if (array[i] > t) {
                mask[i] = 1;
            }
        }
        System.out.println(Arrays.toString(mask));
        int ans = 0;
        int start = 0;
        int end = 0;
        while (end <= n) {
            if (end == n || mask[end] == 1) {
                if (start < end) {
                    int len = end - start;
                    if (c <= len) {
                        ans += (len + 1 - c);
                    }
                }
                start = end + 1;
            }
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int c = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(new Solution2().getTakeOutCount(n, t, c, array));
    }
}
