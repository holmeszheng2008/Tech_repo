package queue_stack;

import java.util.Stack;

// 20. Valid Parentheses
public class Solution20 {
    public boolean isValid(String s) {
        char[] sArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : sArray) {
            if (c == '(' || c == '[' || c == '{') {
               stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
