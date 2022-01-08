package queue_stack;

import java.util.Stack;

// 921. Minimum Add to Make Parentheses Valid
public class Solution921 {
    public int minAddToMakeValid(String s) {
        char[] sArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char element = sArray[i];
            if (stack.isEmpty()) {
                stack.push(element);
                continue;
            }
            char top = stack.peek();
            if (top == ')') {
                stack.push(element);
                continue;
            } else {
                if (element == '(') {
                    stack.push(element);
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size();
    }
}