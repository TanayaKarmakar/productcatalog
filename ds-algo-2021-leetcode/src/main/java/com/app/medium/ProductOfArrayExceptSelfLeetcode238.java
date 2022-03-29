package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 26/03/22
 * @project ds-algo-2021
 */
public class ProductOfArrayExceptSelfLeetcode238 {
    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];

        int left = 1;
        for(int i = 0; i < n; i++) {
            product[i] = left;
            left = left * nums[i];
        }

        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            product[i] = product[i] * right;
            right = right * nums[i];
        }
        return product;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] ans = productExceptSelf(nums);

        System.out.println(Arrays.toString(ans));
    }
}
