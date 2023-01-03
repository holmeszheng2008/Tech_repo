package queue_stack;

import java.util.Stack;

// 32. Longest Valid Parentheses
public class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] memo = new int[s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') {
                stack.push(i);
                memo[i+1] = 0;
            } else {
                if(stack.isEmpty()) {
                    memo[i+1] = 0;
                } else {
                    int leftIndex = stack.pop();
                    int length = i + 1 - leftIndex + memo[leftIndex];
                    memo[i+1] = length;
                }
            }
        }

        int res = 0;
        for(int i : memo){
            res = Math.max(res, i);
        }

        return res;
    }
}
