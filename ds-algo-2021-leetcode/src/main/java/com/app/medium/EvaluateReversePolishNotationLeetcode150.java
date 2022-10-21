package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 29/09/22
 * @project ds-algo-2021-leetcode
 */
public class EvaluateReversePolishNotationLeetcode150 {
    private static boolean isDigit(String token) {
        try {
            Integer el = Integer.parseInt(token);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static int performOp(int num1, int num2, String operator) {
        switch (operator) {
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

    private static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            if(isDigit(tokens[i])) {
                stack.push(tokens[i]);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());

                int result = performOp(num1, num2, tokens[i]);
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {

    }
}
