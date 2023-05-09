package com.app.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author t0k02w6 on 09/05/23
 * @project ds-algo-2021-leetcode
 */
public class DailyTemperatureLeetcode739 {
  private static int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] ans = new int[n];

    Stack<Integer> tempStack = new Stack<>();
    tempStack.push(n - 1);

    for(int i = n - 2; i >= 0; i--) {
      if(!tempStack.isEmpty() && temperatures[i] > temperatures[tempStack.peek()]) {
        while(!tempStack.isEmpty() && temperatures[tempStack.peek()] <= temperatures[i]) {
          tempStack.pop();
        }
      }
      if(!tempStack.isEmpty()) {
        ans[i] = (tempStack.peek() - i);
      }
      tempStack.push(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] temperatures = {73,74,75,71,69,72,76,73};

    int[] ans = dailyTemperatures(temperatures);

    System.out.println(Arrays.toString(ans));
  }
}
