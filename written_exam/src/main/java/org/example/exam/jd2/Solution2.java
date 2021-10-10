package org.example.exam.jd2;

import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 输出：
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution2 {
    public static int getAns(int a, int b, int f, int k) {
        int left = 0;
        int right = 10000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (function(mid, a, b, f, b) == k) {
                right = mid;
            } else if (function(mid, a, b, f, b) > k) {
                right = mid;
            } else if (function(mid, a, b, f, b) < k) {
                left = mid + 1;
            }
        }
        return left == 10001 ? -1 : left;
    }

    /**
     * 充电x次可以完成多少次。x是变量，a、b、f、curPower是参数。
     */
    private static int function(int x, int a, int b, int f, int curPower) {
        int k = 0;
        // 还没走到f
        if (curPower < f) {
            return k;
        }
        curPower -= f;
        // 如果可以充电，且需要充电时，充电
        if (x > 0 && curPower < 2 * (a - f)) {
            curPower = b;
            x--;
        }
        // 走到f了，但没走到a
        if (curPower < a - f) {
            return k;
        }
        // 能量值为curPower-(a-f)
        curPower -= (a - f);
        // 走到a了
        k += 1;
        // 反过来了，充电坐标变成a-f
        k += function(x, a, b, a - f, curPower);
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int f = sc.nextInt();
        // int k = sc.nextInt();
        // int a = 6;
        // int b = 9;
        // int f = 2;
        // int k = 4;
        // int a = 6;
        // int b = 10;
        // int f = 2;
        // int k = 4;
        int a = 6;
        int b = 5;
        int f = 4;
        int k = 3;
        // System.out.println(function(100, a, b, f, b));
        System.out.println(getAns(a, b, f, k));
    }
}
