package dp;

// 309. Best Time to Buy and Sell Stock with Cooldown
public class Solution309 {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length + 2][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = 0;
        dp[1][1] = Integer.MIN_VALUE;

        for(int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 2]);
        }

        return dp[prices.length + 1][0];
    }
}