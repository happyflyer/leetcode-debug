package org.example.exam.pdd1;

import java.util.Scanner;

/**
 * 圆与坐标轴交点个数。
 * <p>
 * 输入：
 * 3
 * 1 1 1
 * 1 1 2
 * 3 4 5
 * 输出：
 * 2
 * 4
 * 3
 *
 * @author lifei
 */
public class Solution1 {
    public int countCrossDot(int x, int y, int r) {
        x = Math.abs(x);
        y = Math.abs(y);
        // 圆心在坐标轴上
        if (x == 0) {
            return y >= r ? 2 : 4;
        }
        if (y == 0) {
            return x >= r ? 2 : 4;
        }
        // 圆心不在坐标轴上
        int a;
        if (x == r) {
            a = 1;
        } else {
            a = x > r ? 0 : 2;
        }
        int b;
        if (y == r) {
            b = 1;
        } else {
            b = y > r ? 0 : 2;
        }
        int ans = a + b;
        // 圆心经过原点
        if (x * x + y * y == r * r) {
            ans--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(new Solution1().countCrossDot(x, y, r));
        }
    }
}
