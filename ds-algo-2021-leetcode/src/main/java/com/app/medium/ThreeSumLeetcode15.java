package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
public class ThreeSumLeetcode15 {
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new LinkedHashSet<>();

        for(int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            List<Integer> currentResult = new ArrayList<>();
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    currentResult = new ArrayList<>();
                    currentResult.add(nums[i]);
                    currentResult.add(nums[start]);
                    currentResult.add(nums[end]);
                    result.add(currentResult);
                    start++;
                    end--;
                } else if(sum < 0)
                    start++;
                else
                    end--;
            }
        }
        return new ArrayList<>(result);
    }
}
