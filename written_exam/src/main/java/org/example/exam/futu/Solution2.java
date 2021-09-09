package org.example.exam.futu;

/**
 * 题目描述：
 * 输入：10,1
 * 输出：10
 * 说明：
 * 输入：3,2
 * 输出：2
 * 输入：105,2
 * 输出：14
 * 通过：
 *
 * @author lifei
 */
public class Solution2 {
    public int solve(int n, int k) {
        if (n < 1 || k < 1) {
            return 0;
        }
        int times = (int) (Math.log(n) / Math.log(2)) + 1;
        if (k >= times) {
            return times;
        }
        int[] dp = new int[k];
        int res = 0;
        while (true) {
            res++;
            int pre = 0;
            for (int i = 0; i < k; i++) {
                int temp = dp[i];
                dp[i] = dp[i] + pre + 1;
                pre = temp;
                if (dp[i] >= n) {
                    return res;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution2().solve(105, 2)
        );
    }
}
