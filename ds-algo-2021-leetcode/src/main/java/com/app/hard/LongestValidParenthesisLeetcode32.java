package com.app.hard;

import java.util.Stack;

public class LongestValidParenthesisLeetcode32 {
    private static int longestValidParenthesis(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }
                max = Integer.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParenthesis("(()"));
        System.out.println(longestValidParenthesis(")()())"));
        System.out.println(longestValidParenthesis(""));
    }
}
