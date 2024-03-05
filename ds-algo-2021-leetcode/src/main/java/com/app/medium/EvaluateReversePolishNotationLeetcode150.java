package com.app.medium;

import java.util.Stack;

public class EvaluateReversePolishNotationLeetcode150 {
    private static int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            if(isDigit(tokens[i])) {
                numStack.push(Integer.parseInt(tokens[i]));
            } else {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                int ans = performOperation(num1, num2, tokens[i]);
                numStack.push(ans);
            }
        }
        return numStack.peek();
    }

    private static int performOperation(int num1, int num2, String token) {
        switch(token) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }

    private static boolean isDigit(String token) {
        try {
            int num = Integer.parseInt(token);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
