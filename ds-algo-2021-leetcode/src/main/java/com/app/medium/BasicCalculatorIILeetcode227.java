package com.app.medium;

import java.util.Stack;

public class BasicCalculatorIILeetcode227 {
    private static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i = 0; i < s.length(); ) {
            if(Character.isDigit(s.charAt(i))) {
                int operand = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    operand = operand * 10 + (s.charAt(i) - '0');
                    i++;
                }

                if(sign == '+') {
                    stack.push(operand);
                } else if(sign == '-') {
                    stack.push(-operand);
                } else if(sign == '*' || sign == '/') {
                    int top = stack.pop();
                    int result = (sign == '*') ? top * operand : top / operand;
                    stack.push(result);
                }
            } else {
                if(s.charAt(i) != ' ') {
                    sign = s.charAt(i);
                }
                i++;
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }
}
