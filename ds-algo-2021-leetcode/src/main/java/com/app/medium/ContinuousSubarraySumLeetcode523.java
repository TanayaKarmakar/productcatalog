package com.app.medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySumLeetcode523 {
    private static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int preSum = 0;
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int r = preSum % k;
            if(map.containsKey(r)) {
                if(i - map.get(r) > 1)
                    return true;
            } else {
                map.put(r, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;

        System.out.println(checkSubarraySum(nums, k));

        nums = new int[]{23,2,6,4,7};
        k = 13;
        System.out.println(checkSubarraySum(nums, k));
    }
}
