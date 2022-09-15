package dp;

// 123. Best Time to Buy and Sell Stock III
// Bottom Up
public class Solution123 {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][3][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }

        return dp[prices.length][2][0];
    }
}


// Top Down
class Solution123_td {
    private int[] prices;
    private Integer[][][] memo;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.memo = new Integer[prices.length][2][2];

        return dp(prices.length - 1, 1, 0);
    }

    private int dp(int i, int j, int hold) {
        if (i == -1) {
            if (hold == 0) {
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        if (j == -1) {
            if (hold == 0) {
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        if (memo[i][j][hold] != null) {
            return memo[i][j][hold];
        }
        int res = 0;
        if (hold == 0) {
            res = Math.max(dp(i - 1, j, 0), dp(i - 1, j, 1) + prices[i]);
        } else {
            res = Math.max(dp(i - 1, j, 1), dp(i - 1, j - 1, 0) - prices[i]);
        }

        memo[i][j][hold] = res;
        return res;
    }
}
