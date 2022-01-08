package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 22. Generate Parentheses
 */
class Solution22_1 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);

        return result;
    }

    private void backtrack(String prefix, int leftCount, int rightCount, int n, List<String> result) {
        if (leftCount == n && rightCount == n) {
            result.add(prefix);
            return;
        }
        if (leftCount > rightCount) {
            if (leftCount < n) {
                prefix += "(";
                leftCount++;
                backtrack(prefix, leftCount, rightCount, n, result);
                prefix = prefix.substring(0, prefix.length() - 1);
                leftCount--;
            }
            prefix += ")";
            rightCount++;
            backtrack(prefix, leftCount, rightCount, n, result);
        } else if (leftCount == rightCount) {
            prefix += "(";
            leftCount++;
            backtrack(prefix, leftCount, rightCount, n, result);
        }
    }
}