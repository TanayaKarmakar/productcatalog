package com.app.medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.text.html.HTMLDocument;

/**
 * @author t0k02w6 on 25/06/23
 * @project ds-algo-2021-leetcode
 */
public class AsteroidCollisionLeetcode735 {
  private static int[] asteroidCollision(int[] asteroids) {
      Stack<Integer> stack = new Stack<>();
      for(int i = 0; i < asteroids.length; i++) {
        int asteroid = asteroids[i];
        if(stack.isEmpty() || asteroid > 0) {
          stack.push(asteroid);
        } else {
          while(true) {
            int top = stack.peek();
            if(top > -asteroid) {
              break;
            } else if(top == -asteroid) {
              stack.pop();
              break;
            } else if(top < 0) {
              stack.push(asteroid);
              break;
            } else {
              stack.pop();
              if(stack.isEmpty()) {
                stack.push(asteroid);
                break;
              }
            }
          }
        }
      }

      int[] result = new int[stack.size()];
      Iterator<Integer> sItr = stack.iterator();
      int j = 0;
      while(sItr.hasNext()) {
        result[j++] = sItr.next();
      }
      return result;
  }


  public static void main(String[] args) {
    int[] asteroids = {5,10,-5};
    int[] ans = asteroidCollision(asteroids);

    System.out.println(Arrays.toString(ans));
  }
}
