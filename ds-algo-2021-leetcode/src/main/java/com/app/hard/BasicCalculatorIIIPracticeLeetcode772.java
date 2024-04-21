package com.app.hard;

import java.util.Stack;

public class BasicCalculatorIIIPracticeLeetcode772 {
    static class Pair {
        Stack<Integer> stack;
        char sign;

        public Pair(Stack<Integer> stack, char sign) {
            this.stack = stack;
            this.sign = sign;
        }
    }

    //2*(5+5*2)/3+(6/2+8)
    private static int solve(String str) {
        Stack<Pair> parenStack = new Stack<>();
        char sign = '+';
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < str.length();) {
            if(Character.isDigit(str.charAt(i))) {
                int value = 0;
                while(Character.isDigit(str.charAt(i))) {
                    value = value * 10 + (str.charAt(i) - '0');
                    i++;
                }

                performOp(value, stack, sign);
            } else if(str.charAt(i) == '(') {
                Pair pair = new Pair(stack, sign);
                parenStack.push(pair);
                stack = new Stack<>();
                sign = '+';
                i++;
            } else if(str.charAt(i) == ')') {
                int value = 0;
                while(!stack.isEmpty()) {
                    value += stack.pop();
                }
                Pair pair = parenStack.pop();
                stack = pair.stack;
                sign = pair.sign;
                performOp(value, stack, sign);
                i++;
            } else {
                if(str.charAt(i) != ' ') {
                    sign = str.charAt(i);
                }
                i++;
            }
        }

        result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private static void performOp(int value, Stack<Integer> stack, char sign) {
       if(sign == '+') {
           stack.push(value);
       } else if(sign == '-') {
           stack.push(-value);
       } else if(sign == '*' || sign == '/') {
           int num2 = stack.pop();
           int result = (sign == '*') ? (value * num2) : (value / num2);
           stack.push(result);
       }
    }

    public static void main(String[] args) {

    }
}
