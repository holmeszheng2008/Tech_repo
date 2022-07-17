package binary_search_tree;

// 96. Unique Binary Search Trees
public class Solution96 {
    private Integer[] memo;
    public int numTrees(int n) {
        memo = new Integer[n + 1];
        return helper(n);
    }

    public int helper(int n) {
        int count = 0;
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        for (int i = 1; i <= n; i++) {
            count += helper(i - 1) * helper(n - i);
        }

        memo[n] = count;
        return count;
    }
}
