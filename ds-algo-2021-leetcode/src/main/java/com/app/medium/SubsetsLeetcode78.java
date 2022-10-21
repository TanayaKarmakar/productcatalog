package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 25/09/22
 * @project ds-algo-2021-leetcode
 */
public class SubsetsLeetcode78 {
    private static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int totalSubsets = (int)Math.pow(2, n);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < totalSubsets; i++) {
            int currentNum = i;
            List<Integer> currRow = new ArrayList<>();
            int j = 0;
            while(currentNum != 0) {
                if((currentNum & 1) == 1) {
                    currRow.add(nums[j]);
                }
                currentNum = currentNum >> 1;
                j++;
            }
            result.add(currRow);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        List<List<Integer>> result = subsets(nums);

        System.out.println(result);
    }
}
