package com.app.medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author t0k02w6 on 29/03/22
 * @project ds-algo-2021
 */
public class AsteroidCollisionLeetcode735 {
    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < asteroids.length; i++) {
            if(stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while(true) {
                    int peek = stack.peek();

                    if(peek < 0) { //when stack peek is negative
                        stack.push(asteroids[i]);
                        break;
                    } else if(peek == -asteroids[i]) { //when both magnitudes are equal
                        stack.pop();
                        break;
                    } else if(peek > -asteroids[i]) { // when peek's magnitude is greater than new one
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

        int[] result = new int[stack.size()];

        for(int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};

        int[] ans = asteroidCollision(asteroids);

        System.out.println(Arrays.toString(ans));
    }
}
