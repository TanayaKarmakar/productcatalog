package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 20/09/22
 * @project ds-algo-2021-leetcode
 */
public class BuildingsWithOceanViewLeetcode1762 {
    private static int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> result = new ArrayList<>();
        int maxValue = heights[n - 1];
        result.add(n - 1);

        for(int i = n - 2; i >= 0; i--) {
            if(heights[i] > maxValue) {
                result.add(0, i);
                maxValue = heights[i];
            }
        }

        int[] finalResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,3,1};
        int[] ans = findBuildings(nums);

        System.out.println(Arrays.toString(ans));
    }
}
