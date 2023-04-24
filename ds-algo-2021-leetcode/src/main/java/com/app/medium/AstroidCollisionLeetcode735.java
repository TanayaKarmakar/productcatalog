package com.app.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author t0k02w6 on 22/04/23
 * @project ds-algo-2021-leetcode
 */
public class AstroidCollisionLeetcode735 {
  private static int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < asteroids.length; i++) {
      if(stack.isEmpty() || asteroids[i] > 0) {
        stack.push(asteroids[i]);
      } else {
        while(true) {
          int top = stack.peek();
          if(top < 0) {
            stack.push(asteroids[i]);
            break;
          } else if(top == -asteroids[i]) {
            stack.pop();
            break;
          } else if(top > -asteroids[i]) {
            break;
          } else {
            stack.pop();
            if(stack.isEmpty()) {
              stack.push(asteroids[i]);
              break;
            }
          }
        }
      }
    }

    int n = stack.size();
    int[] result = new int[n];
    int j = n - 1;
    while(j >= 0) {
      result[j--] = stack.pop();
    }
    return result;
  }

  private static boolean canCollide(int stackTop, int num) {
    return stackTop > 0 && num < 0;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10, -5})));
    System.out.println(Arrays.toString(asteroidCollision(new int[]{10,2, -5})));
  }
}
