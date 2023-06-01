package com.app.hard;

import java.util.Stack;

/**
 * @author t0k02w6 on 23/05/23
 * @project ds-algo-2021-leetcode
 */
public class LongestValidParenthesisLeetcode32 {

  private static int longestValidParenthesisApproach2(String s) {
    int n = s.length();
    int open = 0;
    int close = 0;
    int max = 0;
    for(int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if(c == '(')
        open++;
      else
        close++;
      if(close > open) {
        open = 0;
        close = 0;
      } else if(open == close) {
        max = Integer.max(max, open + close);
      }
    }

    open = close = 0;
    for(int i = n - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if(c == '(')
        open++;
      else
        close++;
      if(open > close) {
        open = 0;
        close = 0;
      } else if(open == close) {
        max = Integer.max(max, open + close);
      }
    }
    return max;
  }

  private static int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    stack.push(-1);
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if(stack.isEmpty()) {
          stack.push(i);
        }
        max = Integer.max(max, i - stack.peek());
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(longestValidParentheses("(()"));
    System.out.println(longestValidParentheses(")()())"));
    System.out.println(longestValidParenthesisApproach2("(()"));
    System.out.println(longestValidParenthesisApproach2(")()())"));
  }
}
