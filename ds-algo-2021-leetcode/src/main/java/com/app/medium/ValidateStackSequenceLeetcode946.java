package com.app.medium;

import java.util.Stack;

public class ValidateStackSequenceLeetcode946 {
    private static boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int j = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && (stack.peek() == popped[j] || i == n)) {
                stack.pop();
                j++;
            }
        }

        return j == n;
    }

    public static void main(String[] args) {

    }
}
