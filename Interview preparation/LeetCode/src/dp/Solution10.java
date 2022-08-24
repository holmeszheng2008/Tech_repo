package dp;

// 10. Regular Expression Matching
public class Solution10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
            dp[1][1] = true;
        }

        for (int j = 2; j < n + 1; j++) {
            if (j % 2 == 0 && p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 2] || dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[m][n];
    }
}