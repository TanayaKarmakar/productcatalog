package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 23/09/22
 * @project ds-algo-2021-leetcode
 */
public class SplitArrayIntoConsecutiveSubsequencesLeetcode659 {
    private static boolean isPossible(int[] nums) {
        Map<Integer, Integer> availabilityMap = new HashMap<>();
        Map<Integer, Integer> vacancyMap = new HashMap<>();
        for(int num: nums) {
            availabilityMap.put(num, availabilityMap.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i < nums.length; i++) {
            if(availabilityMap.get(nums[i]) <= 0)
                continue;
            else if(vacancyMap.getOrDefault(nums[i], 0) > 0) {
                availabilityMap.put(nums[i], availabilityMap.getOrDefault(nums[i], 0) - 1);
                vacancyMap.put(nums[i], vacancyMap.getOrDefault(nums[i], 0) - 1);
                vacancyMap.put(nums[i] + 1, vacancyMap.getOrDefault(nums[i] + 1, 0) + 1);
            } else if(availabilityMap.getOrDefault(nums[i], 0) > 0 &&
            availabilityMap.getOrDefault(nums[i] + 1, 0) > 0 &&
            availabilityMap.getOrDefault(nums[i] + 2, 0) > 0) {
                availabilityMap.put(nums[i], availabilityMap.getOrDefault(nums[i], 0) - 1);
                availabilityMap.put(nums[i] + 1, availabilityMap.getOrDefault(nums[i] + 1, 0) - 1);
                availabilityMap.put(nums[i] + 2, availabilityMap.getOrDefault(nums[i] + 2, 0) - 1);
                vacancyMap.put(nums[i] + 3, vacancyMap.getOrDefault(nums[i] + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
