package org.example.leetcode.exam.yuanfudao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 中奖种类多少种。
 * n个数，
 * 抽m次（抽完放回），
 * 按照抽取顺序组成m位的C，
 * C%x=k 且 C任意相邻位上数和为奇数，中奖。
 * <p>
 * 输入：
 * 3 2 0 2
 * 1 4 3
 * 输出：
 * 2
 * 说明：
 * 11 14 13 41 44 43 31 34 33，中奖的是：14 34
 * <p>
 * 输入：
 * 3 3 1 2
 * 1 4 3
 * 输出：
 * 4
 * 说明：
 * 141 143 341 343
 *
 * @author lifei
 */
public class Solution3 {
    public int getCount(int n, int m, int k, int x, int[] arr) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] split = line1.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        int x = Integer.parseInt(split[3]);
        String line2 = sc.nextLine();
        String[] strArr = line2.split(" ");
        int[] intArr = Arrays.stream(strArr).mapToInt(Integer::valueOf).toArray();
        System.out.println(new Solution3().getCount(n, m, k, x, intArr));
    }
}
