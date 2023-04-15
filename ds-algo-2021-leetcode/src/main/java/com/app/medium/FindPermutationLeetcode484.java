package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 13/04/23
 * @project ds-algo-2021-leetcode
 */
public class FindPermutationLeetcode484 {
  private static int[] findPermutation(String s) {
    int n = s.length();
    int[] res = new int[n + 1];

    Stack<Integer> stack = new Stack<>();
    int j = 0;
    for(int i = 0; i <= n; i++) {
      stack.push((i + 1));
      if(i == n || s.charAt(i) == 'I') {
        while(!stack.isEmpty()) {
          res[j++] = stack.pop();
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {

  }
}
