package com.app.easy;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author t0k02w6 on 25/07/21
 * @project ds-algo-2021
 */
public class ValidParenthesisLeetcode20 {
    private static boolean isMatch(char prev, char curr) {
        return (prev == '(' && curr == ')')
                || (prev == '{' && curr == '}')
                || (prev == '[' && curr == ']');
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if(stack.isEmpty() || !isMatch(stack.pop(), s.charAt(i)))
                    return false;
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(isValid(str));
    }
}
