package org.example.leetcode.dp.stock;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution121 {
    /**
     * 贪心。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution121().maxProfit(new int[]{7, 1, 5, 3, 6, 4})
        );
    }
}
