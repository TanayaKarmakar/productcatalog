package com.app.easy;

import java.util.Stack;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class BaseBallGameLeetcode682 {
    private static boolean isDigit(String str) {
        try {
            int val = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if(isDigit(op)) {
                stack.push(Integer.parseInt(op));
            } else {
                if(op.equals("C")) {
                    stack.pop();
                } else if(op.equals("D")) {
                    stack.push(stack.peek() * 2);
                } else {
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(val1);
                    stack.push(val2);
                    stack.push(val1 + val2);
                }
            }
        }

        int total = 0;
        while(!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
