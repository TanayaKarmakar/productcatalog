package com.app.easy;

import java.util.Stack;

/**
 * @author t0k02w6 on 25/01/23
 * @project ds-algo-2021
 */
public class ValidParenthesisLeetcode20 {
  private static final char OPEN_PAREN = '(';
  private static final char CLOSE_PAREN = ')';
  private static final char OPEN_BRACES = '{';
  private static final char CLOSE_BRACES = '}';
  private static final char OPEN_SQUARE = '[';
  private static final char CLOSE_SQUARE = ']';

  private static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(ch == CLOSE_PAREN || ch == CLOSE_BRACES || ch == CLOSE_SQUARE) {
        if(stack.isEmpty())
          return false;
        if(!isValidMatch(ch, stack.peek()))
          return false;
        stack.pop();
      } else {
        stack.push(ch);
      }
    }
    return stack.isEmpty();
  }

  private static boolean isValidMatch(char ch, char peekChar) {
    return (ch == CLOSE_PAREN && peekChar == OPEN_PAREN) || (ch == CLOSE_BRACES &&
        peekChar == OPEN_BRACES) || (ch == CLOSE_SQUARE && peekChar == OPEN_SQUARE);
  }

  public static void main(String[] args) {

  }
}
