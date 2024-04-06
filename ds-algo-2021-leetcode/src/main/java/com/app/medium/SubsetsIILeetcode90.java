package com.app.medium;

import java.util.*;

public class SubsetsIILeetcode90 {
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        int totalCombinations = (int)Math.pow(2, n);
        for(int i = 0; i < totalCombinations; i++) {
            int current = i;
            List<Integer> currentResult = new ArrayList<>();
            int j = 0;
            while(current != 0) {
                if((current & 1) == 1) {
                    currentResult.add(nums[j]);
                }
                current = (current >> 1);
                j++;
            }
            result.add(currentResult);
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> result = subsetsWithDup(nums);

        System.out.println(result);
    }
}
