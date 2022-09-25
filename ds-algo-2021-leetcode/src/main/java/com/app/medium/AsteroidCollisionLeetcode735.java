package com.app.medium;

import java.util.Stack;

/**
 * @author t0k02w6 on 23/09/22
 * @project ds-algo-2021-leetcode
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
                    if(peek < 0) {
                        stack.push(asteroids[i]);
                        break;
                    } else if(peek == -asteroids[i]) {
                        stack.pop();
                        break;
                    } else if(peek > -asteroids[i]) {
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
        int i = stack.size() - 1;
        while(!stack.isEmpty()) {
            result[i--] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
