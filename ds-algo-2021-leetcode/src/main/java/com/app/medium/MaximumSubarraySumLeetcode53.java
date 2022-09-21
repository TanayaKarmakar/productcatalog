package com.app.medium;

/**
 * @author t0k02w6 on 17/09/22
 * @project ds-algo-2021-leetcode
 */
public class MaximumSubarraySumLeetcode53 {
    private static int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Integer.max(maxSum, currentSum);
            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
