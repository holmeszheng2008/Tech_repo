package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 22. Generate Parentheses
 */
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateResult("", result, 0, 0, n);

        return result;
    }

    private void generateResult(String prefix, List<String> result, int leftCount, int rightCount, int n) {
        if (leftCount == n) {
            if (rightCount < n) {
                generateResult(prefix + ")", result, leftCount, rightCount + 1, n);
            } else {
                result.add(prefix);
                return;
            }
        } else if (leftCount == rightCount) {
            generateResult(prefix + "(", result, leftCount + 1, rightCount, n);
        } else {
            generateResult(prefix + "(", result, leftCount + 1, rightCount, n);
            generateResult(prefix + ")", result, leftCount, rightCount + 1, n);
        }
    }
}