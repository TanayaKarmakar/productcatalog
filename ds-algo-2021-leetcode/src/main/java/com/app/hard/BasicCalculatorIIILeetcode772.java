package com.app.hard;

import java.util.Stack;

public class BasicCalculatorIIILeetcode772 {
    static class Pair {
        Stack<Integer> stack;
        char sign;

        public Pair(Stack<Integer> stack, char sign) {
            this.stack = stack;
            this.sign = sign;
        }
    }

    private static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Pair> parenStack = new Stack<>();
        char sign = '+';
        int value = 0;
        int n = s.length();
        for(int i = 0; i < n; ) {
            if(Character.isDigit(s.charAt(i))) {
                value = 0;
                while(i < n && Character.isDigit(s.charAt(i))) {
                    value = (value * 10) + (s.charAt(i) - '0');
                    i++;
                }
                performOp(stack, value, sign);
            } else if(s.charAt(i) == '(') {
                parenStack.push(new Pair(stack, sign));
                stack = new Stack<>();
                sign = '+';
                i++;
            } else if(s.charAt(i) == ')') {
                value = 0;
                while(!stack.isEmpty()) {
                    value += stack.pop();
                }
                Pair pair = parenStack.pop();
                stack = pair.stack;
                sign = pair.sign;
                performOp(stack, value, sign);
                i++;
            } else if(s.charAt(i) != ' ') {
                sign = s.charAt(i);
                i++;
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    private static void performOp(Stack<Integer> stack, int value, char sign) {
        if(sign == '+') {
            stack.push(value);
        } else if(sign == '-') {
            stack.push(-value);
        } else if(sign == '*' || sign == '/') {
            int operand = stack.pop();
            int result = (sign == '*') ? (operand * value) : (operand / value);
            stack.push(result);
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));
    }
}
