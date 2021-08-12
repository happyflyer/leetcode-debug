package org.example.jianzhi.dp;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183
 *
 * @author lifei
 */
public class Jz30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int greatSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : array) {
            sum = sum <= 0 ? val : (sum + val);
            greatSum = Math.max(greatSum, sum);
            System.out.println("sum = " + sum + ", greatSum = " + greatSum);
        }
        return greatSum;
    }

    /**
     * 动态规划。
     * 状态定义：dp[i]表示以i结尾的连续子数组的最大和。所以最终要求dp[n-1]。
     * 状态转移方程：dp[i] = max(array[i], dp[i-1]+array[i])。
     * 最后返回dp中的最大值。
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int[] cache = new int[n];
        cache[0] = array[0];
        int ret = cache[0];
        for (int i = 1; i < n; i++) {
            cache[i] = Math.max(array[i], cache[i - 1] + array[i]);
            ret = Math.max(ret, cache[i]);
        }
        System.out.println(Arrays.toString(cache));
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz30().FindGreatestSumOfSubArray2(new int[]{1, -2, 3, 10, -4, 7, 2, -5})
        );
    }
}
