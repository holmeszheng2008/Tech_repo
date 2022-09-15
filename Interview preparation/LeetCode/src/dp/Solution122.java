package dp;

// 122. Best Time to Buy and Sell Stock II
public class Solution122 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }

        return dp[prices.length][0];
    }
}


// Top Down
class Solution122_td {
    private int[] prices;
    private Integer[][] memo;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new Integer[prices.length][2];

        return dp(prices.length - 1, 0);
    }

    private int dp(int i, int hold) {
        if (i == -1) {
            if (hold == 0) {
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        if (memo[i][hold] != null) {
            return memo[i][hold];
        }

        int res = 0;
        if (hold == 0) {
            res = Math.max(dp(i - 1, hold), dp(i - 1, 1) + prices[i]);
        } else {
            res = Math.max(dp(i - 1, hold), dp(i - 1, 0) - prices[i]);
        }

        memo[i][hold] = res;
        return res;
    }
}
