package dp;

// 300. Longest Increasing Subsequence
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int preMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    preMax = Math.max(preMax, dp[j]);
                }
            }
            dp[i] = preMax + 1;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}