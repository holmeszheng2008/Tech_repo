package backtracking;

import java.util.ArrayList;
import java.util.List;

// 22. Generate Parentheses
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


class Solution22_attempt1 {
    private StringBuilder sb = new StringBuilder();
    private List<String> res = new ArrayList<>();
    private int leftCount;
    private int rightCount;
    public List<String> generateParenthesis(int n) {
        this.leftCount = n;
        this.rightCount = n;

        backtracking(0);
        return res;
    }
    private void backtracking(int i){
        if(leftCount == 0) {
            // add right only
            sb.append(')');
            rightCount--;
            if(rightCount == 0) {
                res.add(sb.toString());
            } else {
                backtracking(i+1);
            }
            rightCount++;
            sb.deleteCharAt(sb.length() - 1);
        } else if (leftCount - rightCount == 0){
            // add leftOnly
            sb.append('(');
            leftCount--;
            backtracking(i+1);
            leftCount++;
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append('(');
            leftCount--;
            backtracking(i+1);
            leftCount++;
            sb.deleteCharAt(sb.length() - 1);

            sb.append(')');
            rightCount--;
            backtracking(i+1);
            rightCount++;
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}