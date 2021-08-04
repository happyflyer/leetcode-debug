package org.example.leetcode.jianzhi.greedy;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author lifei
 */
public class Leetcode121 {
    /**
     * 暴力法
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    /**
     * 遍历一次
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(
                new Leetcode121().maxProfit2(new int[]{1, 2, 11, 4, 7})
        );
    }
}
