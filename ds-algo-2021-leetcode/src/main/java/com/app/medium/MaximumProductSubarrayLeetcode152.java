package com.app.medium;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class MaximumProductSubarrayLeetcode152 {
    private static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            res = Integer.max(nums[i], res);
        }

        int currMin = 1;
        int currMax = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                currMax = 1;
                currMin = 1;
            } else {
                int tmp = currMax * nums[i];
                currMax = Integer.max(tmp, Integer.max(nums[i] * currMin, nums[i]));
                currMin = Integer.min(tmp, Integer.min(nums[i] * currMin, nums[i]));
                res = Integer.max(res, currMax);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int ans = maxProduct(nums);

        System.out.println(ans);
    }
}
