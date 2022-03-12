package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author t0k02w6 on 11/03/22
 * @project ds-algo-2021
 */
public class OceanViewLeetcode1762 {
    private static int[] findBuildings(int[] heights) {
       Stack<Integer> stack = new Stack<>();
       int n = heights.length;
       stack.push((n - 1));
       int max = heights[n - 1];

       for(int i = n - 2; i >= 0; i--) {
           if(heights[i] > max) {
               max = heights[i];
               stack.push(i);
           }
       }

       int[] result = new int[stack.size()];
       int i = 0;
       while(!stack.isEmpty()) {
           result[i++] = stack.pop();
       }
       return result;
    }

    public static void main(String[] args) {
        int[] heights = {4,2,3,1};

        System.out.println(Arrays.toString(findBuildings(heights)));
    }
}
