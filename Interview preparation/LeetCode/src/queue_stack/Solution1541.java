package queue_stack;

import java.util.Stack;

// 1541. Minimum Insertions to Balance a Parentheses String
public class Solution1541 {
    public int minInsertions(String s) {
        char[] sArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int needs = 0;
        for (int i = 0; i < sArray.length; i++) {
            char element = sArray[i];
            if (stack.isEmpty()) {
                if (element == '(') {
                    stack.push(element);
                } else {
                    i++;
                    if (i >= sArray.length) {
                        needs += 2;
                    } else {
                        char nextEle = sArray[i];
                        if (nextEle == '(') {
                            needs += 2;
                            stack.push(nextEle);
                        } else {
                            needs += 1;
                        }
                    }
                }
                continue;
            }
            // top is always '('
            if (element == '(') {
                stack.push(element);
            } else {
                i++;
                if (i >= sArray.length) {
                    stack.pop();
                    needs += 1;
                } else {
                    char nextEle = sArray[i];
                    if (nextEle == '(') {
                        needs += 1;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        needs += stack.size() * 2;

        return needs;
    }
}
