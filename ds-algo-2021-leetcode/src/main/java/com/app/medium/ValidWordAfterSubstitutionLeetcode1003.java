package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 13/04/23
 * @project ds-algo-2021-leetcode
 */
public class ValidWordAfterSubstitutionLeetcode1003 {
  private static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(ch == 'c') {
        if(stack.isEmpty() || stack.size() < 2)
          return false;
        char ch2 = stack.pop();
        char ch1 = stack.pop();
        if(ch1 != 'a' || ch2 != 'b')
          return false;
      } else {
        stack.push(ch);
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {

  }
}
