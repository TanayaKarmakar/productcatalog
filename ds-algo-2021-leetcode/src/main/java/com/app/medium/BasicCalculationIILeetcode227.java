package com.app.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/09/22
 * @project ds-algo-2021-leetcode
 */
public class BasicCalculationIILeetcode227 {
    private static int calculate(String s) {
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ')
                q.add(s.charAt(i));
        }
        q.add(' ');
        return helper(q);
    }

    private static int helper(Queue<Character> q) {
        int prev = 0;
        int sum = 0;
        char prevOp = '+';
        int num = 0;
        while(!q.isEmpty()) {
            char ch = q.poll();

            if(ch == '(')
                num = helper(q);
            else if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                switch (prevOp) {
                    case '+':
                        sum = sum + prev;
                        prev = num;
                        break;
                    case '-':
                        sum = sum + prev;
                        prev = -num;
                        break;
                    case '*':
                        prev = prev * num;
                        break;
                    case '/':
                        prev = prev / num;
                        break;
                }
                if(ch == ')')
                    break;
                prevOp = ch;
                num = 0;
            }
        }
        return (sum + prev);
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }
}
