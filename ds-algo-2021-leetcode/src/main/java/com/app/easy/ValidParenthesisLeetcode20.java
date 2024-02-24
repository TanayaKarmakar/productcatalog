package com.app.easy;

import java.util.Stack;

public class ValidParenthesisLeetcode20 {
    private static final char OPENING_PAREN = '(';
    private static final char CLOSING_PAREN = ')';
    private static final char OPENING_BRACES = '{';
    private static final char CLOSING_BRACES = '}';
    private static final char OPENING_SQUARE = '[';
    private static final char CLOSING_SQUARE = ']';

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == CLOSING_PAREN || ch == CLOSING_BRACES || ch == CLOSING_SQUARE) {
                if(!stack.isEmpty()) {
                    if(!isMatch(stack.peek(), ch))
                        return false;
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatch(char topChar, char currentChar) {
        return (currentChar == CLOSING_PAREN && topChar == OPENING_PAREN)
                || (currentChar == CLOSING_BRACES && topChar == OPENING_BRACES)
                || (currentChar == CLOSING_SQUARE && topChar == OPENING_SQUARE);
    }

    public static void main(String[] args) {

    }
}
