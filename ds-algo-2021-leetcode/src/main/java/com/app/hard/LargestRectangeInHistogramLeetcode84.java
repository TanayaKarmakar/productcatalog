package com.app.hard;

import java.util.Stack;

public class LargestRectangeInHistogramLeetcode84 {
    public static int largestRectangleArea(int[] heights) {
        int[] prevSmaller = calculatePrevSmallerElement(heights);
        int[] nextSmaller = calculateNextSmallerElement(heights);

        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        for(int i = 0; i < heights.length; i++) {
            if(nextSmaller[i] == -1) {
                nextSmaller[i] = n;
            }
            int currentArea = heights[i] * (nextSmaller[i] - prevSmaller[i] - 1);
            maxArea = Integer.max(maxArea, currentArea);
        }
        return maxArea;
    }

    private static int[] calculateNextSmallerElement(int[] heights) {
        int n = heights.length;
        int[] next = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = n - 1; i >= 0; i--) {
            int current = heights[i];
            while(stack.peek() != -1 && heights[stack.peek()] >= current) {
                stack.pop();
            }
            next[i] = stack.peek();
            stack.push(i);
        }
        return next;
    }

    private static int[] calculatePrevSmallerElement(int[] heights) {
        int n = heights.length;
        int[] prev = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = 0; i < n; i++) {
            int current = heights[i];
            while(stack.peek() != -1 && heights[stack.peek()] >= current) {
                stack.pop();
            }
            prev[i] = stack.peek();
            stack.push(i);
        }
        return prev;
    }


    public static void main(String[] args) {

    }
}
