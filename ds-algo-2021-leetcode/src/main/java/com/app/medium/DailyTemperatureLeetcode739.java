package com.app.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author t0k02w6 on 02/10/22
 * @project ds-algo-2021-leetcode
 */
public class DailyTemperatureLeetcode739 {
  private static int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] ans = new int[n];
    ans[n - 1] = 0;

    int j = n - 2;

    Stack<Integer> stack = new Stack<>();
    stack.push(n - 1);

    for(int i = n - 2; i >= 0; i--) {
      if(stack.isEmpty()) {
        ans[j--] = 0;
      } else if(temperatures[i] < temperatures[stack.peek()]) {
        ans[j--] = 1;
      } else {
        while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
          stack.pop();
        }
        if(!stack.isEmpty()) {
          ans[j--] = (stack.peek() - i);
        } else {
          ans[j--] = 0;
        }
      }
      stack.push(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] temperatures = {73,74,75,71,69,72,76,73};
    int[] result = dailyTemperatures(temperatures);

    System.out.println(Arrays.toString(result));
  }
}
