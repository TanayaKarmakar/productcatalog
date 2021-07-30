package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 29/07/21
 * @project ds-algo-2021
 */
public class ThreeSumClosestLeetcode16 {
    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(target == sum)
                    return target;
                else {
                    int currentDiff = Math.abs(target - sum);
                    if(minDiff > currentDiff) {
                        minDiff = currentDiff;
                        closestSum = sum;
                    }
                    if(sum > target)
                        end--;
                    else
                        start++;

                }
            }
        }
        return closestSum;
    }



    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};

        int target = 1;

        int ans = threeSumClosest(nums, target);
        System.out.println(ans);
    }
}
