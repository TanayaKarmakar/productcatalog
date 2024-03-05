package com.app.medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

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

        int[] res = new int[stack.size()];
        Iterator<Integer> sItr = stack.iterator();

        int i = 0;
        while(sItr.hasNext()) {
            res[i++] = sItr.next();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10,2,-5})));
    }
}
