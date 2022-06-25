package queue_stack;

import java.util.Stack;

// 739. Daily Temperatures (monotonic stack)
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temp = temperatures[i];
            while (!stack.isEmpty()) {
                if (stack.peek()[1] <= temp) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek()[0] - i;
            }

            stack.push(new int[] {i, temperatures[i]});
        }
        return res;
    }
}
