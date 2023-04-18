package com.app.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author t0k02w6 on 17/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumRemoveToMakeValidParenthesisLeetcode1249 {
  private static String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();
    Set<Integer> excludedIndices = new HashSet<>();

    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if(ch == ')') {
        if(stack.isEmpty()) {
          excludedIndices.add(i);
        } else {
          if(s.charAt(stack.peek()) == '(')
            stack.pop();
        }
      } else if(ch == '('){
        stack.push(i);
      }
    }

    while(!stack.isEmpty()) {
      excludedIndices.add(stack.pop());
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length(); i++) {
      if(!excludedIndices.contains(i)) {
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {

  }
}
