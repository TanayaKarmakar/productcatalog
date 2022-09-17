package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 24/03/22
 * @project ds-algo-2021
 */
public class BasicCalculatorIILeetcode227 {
    private static int precedence_1 = 1;
    private static int precedence_2 = 2;

    private static int getPrecedence(char ch) {
        if(ch == '+' || ch == '-')
            return precedence_1;
        else
            return precedence_2;
    }


    private static int calculate(String s) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for(int i = 0; i < s.length();) {
            if(Character.isDigit(s.charAt(i))) {
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                operandStack.push(num);
            } else if(s.charAt(i) == ' ') {
                i++;
                continue;
            } else {
                if(operatorStack.isEmpty() || getPrecedence(s.charAt(i)) > getPrecedence(operatorStack.peek())) {
                    operatorStack.push(s.charAt(i));
                } else {
                    int num2 = operandStack.pop();
                    int num1 = operandStack.pop();
                    char prevOp = operatorStack.pop();
                    int result = performOperation(num1, num2, prevOp);
                    operandStack.push(result);
                    operatorStack.push(s.charAt(i));
                }
                i++;
            }
        }
        //if(operandStack.size() == 1)
        while(operandStack.size() > 1) {
            char op = operatorStack.pop();
            int num2 = operandStack.pop();
            int num1 = operandStack.pop();
            int result = performOperation(num1, num2, op);
            operandStack.push(result);
        }
        return operandStack.peek();
    }

    private static int performOperation(int num1, int num2, char prevOp) {
        switch (prevOp) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = " 3+5 / 2 ";
        int ans = calculate(str);

        System.out.println(ans);
    }
}
