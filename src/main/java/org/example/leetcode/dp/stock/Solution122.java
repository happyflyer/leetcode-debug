package org.example.leetcode.dp.stock;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution122 {
    /**
     * 贪心。
     * 累加所有的单调增区间。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    /**
     * 动态规划。
     * 在买卖股票过程中，有两个状态，未持有股票状态cash，持有股票状态hold。
     * 最后获得的最大收益一定是未持有股票状态的最大值。
     * 1、当未持有股票时，未持有股票状态的最大值，
     * 要么是之前的未持有股票的最大值，要么是当前持有的股票卖出。
     * cash = max(cash, hold + prices[i])
     * 2、当持有股票时，持有股票的最大值，
     * 要么是之前持有股票的最大值，要么是当前买入股票。
     * hold = max(hold, cash - prices[i])
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int cash = 0;
        int hold = prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i]);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    /**
     * 动态规划。
     * dp[i][0]表示第i天不持有股票，dp[i][1]表示第i天持有股票的收益。
     */
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        // 如果第0天买入，那么当前收益为-price[0]
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 第i天不持有股票，可能是i-1天就不持有，或者i-1天持有，但是第i天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i天持有，可能是i-1天就持有，或者i-1天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution122().maxProfit(new int[]{7, 1, 5, 3, 6, 4})
        );
    }
}
