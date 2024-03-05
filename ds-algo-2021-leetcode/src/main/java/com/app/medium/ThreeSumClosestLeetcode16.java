package com.app.medium;

import java.util.Arrays;

public class ThreeSumClosestLeetcode16 {
    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int finalTarget = 0;

        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            int start = i + 1;
            int end = n - 1;
            while(start < end) {
                int currentTarget = nums[i] + nums[start] + nums[end];
                if(currentTarget == target)
                    return currentTarget;
                int currentDiff = Math.abs(target - currentTarget);
                if(currentDiff < minDiff) {
                    minDiff = currentDiff;
                    finalTarget = currentTarget;
                }
                if(currentTarget > target)
                    end--;
                else
                    start++;
            }
        }

        return finalTarget;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,4};
        int target = 1;

        int ans = threeSumClosest(nums, target);

        System.out.println(ans);
    }
}
