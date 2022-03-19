package com.app.easy;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
public class MissingNumberLeetcode268 {
    private static int missingNumber(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i <= nums.length; i++) {
            totalSum += i;
        }

        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
        }
        return (totalSum - currentSum);
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};

        int ans = missingNumber(nums);
        System.out.println(ans);
    }
}
