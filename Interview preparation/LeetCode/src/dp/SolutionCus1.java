package dp;

// Fabonacci dp memo
public class SolutionCus1 {
    private static Integer[] memo = null;
    public int feb(int n) {
        if (memo == null) {
            memo = new Integer[n + 1];
        }
        if (memo[n] != null) {
            return memo[n];
        }
        if (n == 0 || n == 1) {
            memo[n] = 1;
        } else {
            memo[n] = feb(n - 1) + feb(n - 2);
        }
        return memo[n];
    }
}
