package com.app.easy;

import java.util.Stack;

/**
 * @author t0k02w6 on 10/07/23
 * @project ds-algo-2021-leetcode
 */
public class ValidParenthesisLeetcode20 {
  private static final char OPEN_PAREN = '(';
  private static final char OPEN_BRACES = '{';
  private static final char OPEN_SQUARE = '[';
  private static final char CLOSED_SQUARE = ']';
  private static final char CLOSED_BRACES = '}';
  private static final char CLOSED_PAREN = ')';

  private static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(ch == CLOSED_BRACES || ch == CLOSED_SQUARE || ch == CLOSED_PAREN) {
        if(!stack.isEmpty()) {
          if(!isValid(ch, stack.peek()))
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

  private static boolean isValid(char currentChar, char topChar) {
    return (currentChar == CLOSED_PAREN && topChar == OPEN_PAREN)
        || (currentChar == CLOSED_BRACES && topChar == OPEN_BRACES)
        || (currentChar == CLOSED_SQUARE && topChar == OPEN_SQUARE);
  }

  public static void main(String[] args) {

  }
}
