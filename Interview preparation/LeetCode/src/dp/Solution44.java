package dp;

import java.util.HashMap;
import java.util.Map;

// 44. Wildcard Matching
public class Solution44 {
    private Boolean[][] memo;
    private Map<Integer, Boolean> memoFirst = new HashMap<>();
    private String s;
    private String p;
    public boolean isMatch(String s, String p) {
        this.memo = new Boolean[s.length()][p.length()];
        this.s = s;
        this.p = p;

        return dp(s.length() - 1, p.length() - 1);
    }

    private boolean dp(int i, int j){
        if(i == -1 && j == -1){
            return true;
        }
        if(i == -1) {
            if (p.charAt(j) == '*'){
                if(memoFirst.get(j) != null){
                    memoFirst.get(j);
                }
                boolean res = dp(i, j-1);

                memoFirst.put(j, res);
                return res;
            }
            return false;
        }
        if(j == -1){
            return false;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        boolean res = false;
        if(p.charAt(j) == '*') {
            res = dp(i-1, j) || dp(i-1, j-1) || dp(i, j-1);
        } else if (p.charAt(j) == '?'){
            res = dp(i-1, j-1);
        } else {
            if(s.charAt(i) == p.charAt(j)) {
                res = dp(i - 1, j - 1);
            } else {
                res = false;
            }
        }

        memo[i][j] = res;
        return res;
    }
}
