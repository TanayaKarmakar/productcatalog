package com.app.hard;

import java.util.Stack;

public class BasicCalculatorLeetcode224 {
    private static int calculate(String s) {
        int len = s.length();
        Stack<String> stack = new Stack<>();
        int operand = 0;
        int pow = 0;

        for(int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                int currentNum = (ch - '0');
                operand = (int)Math.pow(10, pow) * currentNum + operand;
                pow++;
            } else if(ch != ' ') {
                if(pow != 0) {
                    stack.push(String.valueOf(operand));
                    operand = 0;
                    pow = 0;
                }
                if(ch == '(') {
                    operand = evaluateExpr(stack);
                    stack.pop();
                    stack.push(String.valueOf(operand));
                    operand = 0;
                } else {
                    stack.push(ch + "");
                }
            }
        }

        if(pow != 0) {
            stack.push(String.valueOf(operand));
        }

        return evaluateExpr(stack);
    }

    private static int evaluateExpr(Stack<String> stack) {
        String top = stack.peek();
        if(!isDigit(top)) {
            stack.push("0");
        }

        int result = Integer.parseInt(stack.pop());
        while(!stack.isEmpty() && !stack.peek().equals(")")) {
            String token = stack.pop();
            if(token.equals("+")) {
                result += Integer.parseInt(stack.pop());
            } else {
                result -= Integer.parseInt(stack.pop());
            }
        }
        return result;
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
