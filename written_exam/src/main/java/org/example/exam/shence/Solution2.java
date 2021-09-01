package org.example.exam.shence;

import java.util.Scanner;

/**
 * 输入：1 2 5
 * 输出：2
 * <p>
 * 输入：-1 4 15
 * 输出：4
 * <p>
 * 输入：0 -1 5
 * 输出：-1
 *
 * @author lifei
 */
public class Solution2 {
    public static int getAns(int x, int y, int m) {
        int cnt = 0;
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        if (min >= m || y >= m) {
            return cnt;
        }
        if (min + max <= min) {
            return -1;
        }
        while (min < m && max < m) {
            // System.out.println("min = " + min + ", max = " + max);
            int tmp = min + max;
            min = Math.min(tmp, max);
            max = Math.max(tmp, max);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(getAns(x, y, m));
    }
}
