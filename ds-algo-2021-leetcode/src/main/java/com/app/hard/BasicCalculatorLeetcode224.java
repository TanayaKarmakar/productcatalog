package com.app.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 04/09/22
 * @project ds-algo-2021-leetcode
 */
public class BasicCalculatorLeetcode224 {
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
        int sum = 0;
        int num = 0;
        int prev = 0;
        char prevOp = '+';
        while(!q.isEmpty()) {
            char c = q.poll();
            if(c == '(')
                num = helper(q);
            else if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                switch (prevOp) {
                    case '+':
                        sum += prev;
                        prev = num;
                        break;
                    case '-':
                        sum += prev;
                        prev = -num;
                        break;
                    case '*':
                        prev = prev * num;
                        break;
                    case '/':
                        prev = prev / num;
                        break;
                }
                if(c == ')')
                    break;
                prevOp = c;
                num = 0;
            }
        }
        return sum + prev;
    }


    public static void main(String[] args) {
        String str = "(1+(4+5+2)-3)+(6+8)";

        int ans = calculate(str);

        System.out.println(ans);
    }
}
