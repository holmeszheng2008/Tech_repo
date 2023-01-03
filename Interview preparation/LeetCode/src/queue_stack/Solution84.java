package queue_stack;

import java.util.Stack;

// 84. Largest Rectangle in Histogram
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        // 0 is index, 1 is value
        Stack<int[]> stack = new Stack<>();
        int[] leftSmaller = new int[heights.length];
        int[] rightSmaller = new int[heights.length];
        int maxSize = 0;

        for(int i = 0; i < heights.length; i++){
            int value = heights[i];
            while(!stack.isEmpty()) {
                int[] topPair = stack.peek();
                if(value < topPair[1]){
                    stack.pop();
                    rightSmaller[topPair[0]] = i;
                } else {
                    break;
                }
            }

            stack.push(new int[]{i, value});
        }

        while(!stack.isEmpty()) {
            int[] topPair = stack.pop();
            rightSmaller[topPair[0]] = heights.length;
        }

        for(int i = heights.length - 1; i >= 0; i--){
            int value = heights[i];
            while(!stack.isEmpty()){
                int[] topPair = stack.peek();
                if(value < topPair[1]){
                    stack.pop();
                    leftSmaller[topPair[0]] = i;
                } else {
                    break;
                }
            }
            stack.push(new int[]{i, value});
        }

        while(!stack.isEmpty()){
            int[] topPair = stack.pop();
            leftSmaller[topPair[0]] = -1;
        }

        for(int i = 0; i < heights.length; i++){
            int length = heights[i];
            int leftBound = leftSmaller[i];
            int rightBound = rightSmaller[i];
            int width = rightBound - leftBound - 1;

            maxSize = Math.max(maxSize, length * width);
        }

        return maxSize;
    }
}
