package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class EvaluateReversePolishNotationLeetcode150 {
    private static boolean isDigit(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            if(isDigit(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(performOp(op1,op2,token));
            }
        }
        return stack.peek();
    }

    private static Integer performOp(int op1, int op2, String token) {
        switch (token) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                return op1 / op2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int ans = evalRPN(tokens);

        System.out.println(ans);
    }
}
