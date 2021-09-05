package org.example.exam.duxiaoman;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 冬天的被窝就如同磁铁一样，吸引着铁打的身体。某天早上，小满由于前一天的修仙，想睡一个时间为k个单位的回笼觉。
 * 老妈会在n个可能的时刻中等可能性地选择两个时刻来叫小满起床。小满会在第一次被叫醒时开始睡回笼觉。
 * 如果老妈第二次来叫她起床时还在睡觉，老妈就会生气。
 * 小满想让你帮她计算，老妈生气的概率。
 * 第一行两个整数n，k（n<=10^5,k<=10^9）
 * 第二行n个互不相同不大于10^9的整数，表示老妈可能来的时间。
 * 输出一个最简分数（或者0/1，表示无论如何老妈都不会生气），表示老妈生气的概率。
 * <p>
 * 输入：
 * 3 1
 * 1 2 3
 * 输出：
 * 2/3
 *
 * @author lifei
 */
public class Solution1 {
    public static String getAns(int n, int k, int[] arr) {
        int a = 0;
        int b = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while (j < n && arr[j] - arr[i] <= k) {
                a++;
                j++;
            }
            b += (n - 1 - i);
        }
        // System.out.println(a);
        // System.out.println(b);
        if (a > 1) {
            int c = getMaxFactor(a, b);
            // System.out.println(c);
            a /= c;
            b /= c;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("/");
        sb.append(b);
        return sb.toString();
    }

    private static int getMaxFactor(int a, int b) {
        if (a < b) {
            return getMaxFactor(b, a);
        }
        if (a % b == 0) {
            return b;
        }
        return getMaxFactor(a - b, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (i < n) {
            arr[i] = sc.nextInt();
            i++;
        }
        // int n = 5;
        // int k = 2;
        // int[] arr = new int[]{1, 3, 4, 5, 7};
        System.out.println(getAns(n, k, arr));
    }
}
