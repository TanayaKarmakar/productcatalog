package com.app.easy;

/**
 * @author t0k02w6 on 25/07/21
 * @project ds-algo-2021
 */
public class SearchInsertPositionLeetcode53 {
    private static int maxSubArray(int[] nums) {
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
