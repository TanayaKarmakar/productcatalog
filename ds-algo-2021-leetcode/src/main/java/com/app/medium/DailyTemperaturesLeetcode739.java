package com.app.medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperaturesLeetcode739 {
    private static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);

        for(int i = n - 2; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        int[] ans = dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(ans));
    }
}
