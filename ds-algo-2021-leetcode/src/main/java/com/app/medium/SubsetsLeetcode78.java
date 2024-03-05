package com.app.medium;

import java.util.ArrayList;
import java.util.List;

public class SubsetsLeetcode78 {
    private static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int totalCombination = (int)Math.pow(2, n);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < totalCombination; i++) {
            int current = i;
            List<Integer> currentResult = new ArrayList<>();
            int j = 0;
            while(current != 0) {
                if((current & 1) == 1) {
                    currentResult.add(nums[j]);
                }
                current = current >> 1;
                j++;
            }
            result.add(currentResult);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = subsets(new int[]{1,2,3});

        System.out.println(result);
    }
}
