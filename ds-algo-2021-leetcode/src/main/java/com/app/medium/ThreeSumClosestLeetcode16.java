package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class ThreeSumClosestLeetcode16 {
    private static int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int closestTarget = 0;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == target)
                    return sum;
                else {
                    int currentDiff = Math.abs(target - sum);
                    if(currentDiff < minDiff) {
                        minDiff = currentDiff;
                        closestTarget = sum;
                    }
                    if(sum > target)
                        end--;
                    else
                        start++;
                }
            }
        }
        return closestTarget;
    }

    public static void main(String[] args) {

    }
}
