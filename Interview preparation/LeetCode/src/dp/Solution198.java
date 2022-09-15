package dp;

// 198. House Robber
// Bottom Up
public class Solution198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
        }

        return dp[nums.length + 1];
    }
}


// Top Down
class Solution198_td {
    private int[] nums;
    private Integer[] memo;
    public int rob(int[] nums) {
        this.memo = new Integer[nums.length];
        this.nums = nums;

        return dp(nums.length - 1);
    }

    int dp(int index) {
        if (index < 0) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }

        int res = Math.max(dp(index - 1), dp(index - 2) + nums[index]);
        memo[index] = res;
        return res;
    }
}
