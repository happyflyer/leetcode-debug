package org.example.exam.wangyileihuo;

import java.util.*;

/**
 * 题目描述：
 * 输入：
 * 15
 * 5
 * 1 1
 * 2 2
 * 3 3
 * 2 1
 * 2 3
 * 输出：
 * 16 1
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution2 {
    public static int[] getAns(int r, int n, int[] px, int[] py) {
        int[] ans = new int[2];
        int[] xLabel = new int[10001];
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, px[i] - r);
            int end = Math.min(10000, px[i] + r);
            for (int j = start; j <= end; j++) {
                xLabel[j] += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int n = sc.nextInt();
        int[] px = new int[n];
        int[] py = new int[n];
        int i = 0;
        while (i < n) {
            px[i] = sc.nextInt();
            py[i] = sc.nextInt();
            i++;
        }
        int[] ans = getAns(r, n, px, py);
        System.out.print(ans[0]);
        if (ans[1] > 0) {
            System.out.print(" " + ans[1]);
        }
    }
}
