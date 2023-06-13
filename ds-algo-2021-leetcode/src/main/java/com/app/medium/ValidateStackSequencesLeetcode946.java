package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 03/06/23
 * @project ds-algo-2021-leetcode
 */
public class ValidateStackSequencesLeetcode946 {
  private static boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int n = pushed.length;
    int j = 0;
    for(int i = 0; i < n; i++) {
      stack.push(pushed[i]);

      while(!stack.isEmpty() && (stack.peek() == popped[j] || i == n)) {
        stack.pop();
        j++;
      }
    }
    return j == n;
  }

  public static void main(String[] args) {
    int[] pushed = {1,2,3,4,5};
    int[] popped = {4,5,3,2,1};

    System.out.println(validateStackSequences(pushed, popped));
  }
}
