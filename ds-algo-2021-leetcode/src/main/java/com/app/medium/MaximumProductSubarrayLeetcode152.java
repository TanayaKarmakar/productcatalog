package com.app.medium;

public class MaximumProductSubarrayLeetcode152 {
    private static int maxProduct(int[] nums) {
        int n = nums.length;
        int numNegatives = 0;
        int numZeros = 0;
        for(int num: nums) {
            if(num < 0)
                numNegatives++;
            else if(num == 0)
                numZeros++;
        }
        if(numNegatives + numZeros == n && numZeros > 0)
            return 0;

        int maxResult = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;


        for(int i = 0; i < n; i++) {
            if(nums[i] == 0)
                prefix = 1;
            if(nums[n - i - 1] == 0)
                suffix = 1;
            if(nums[i] != 0)
                prefix = prefix * nums[i];
            if(nums[n - i - 1] != 0)
                suffix = suffix * nums[n - i - 1];
            maxResult = Integer.max(maxResult, Integer.max(prefix, suffix));
        }
        return maxResult;
    }

    public static void main(String[] args) {
       // System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-3,0,1,-2}));
    }
}
