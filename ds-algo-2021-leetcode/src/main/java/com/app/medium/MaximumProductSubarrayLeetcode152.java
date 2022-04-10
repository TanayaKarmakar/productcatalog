package com.app.medium;

/**
 * @author t0k02w6 on 09/04/22
 * @project ds-algo-2021
 */
public class MaximumProductSubarrayLeetcode152 {
    private static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        int n = nums.length;
        int res = max;
        for(int i = 1; i < n; i++) {
            if(nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Integer.max(nums[i], max * nums[i]);
            min = Integer.min(nums[i], min * nums[i]);
            res = Integer.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        int ans = maxProduct(nums);

        System.out.println(ans);
    }
}
