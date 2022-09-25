package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class ProductOfArrayExceptSelfLeetcode238 {
    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int left = 1;
        int right = 1;

        for(int i = 0; i < n; i++) {
            temp[i] = left;
            left = left * nums[i];
        }

        for(int i = n - 1; i >= 0; i--) {
            temp[i] = temp[i] * right;
            right = right * nums[i];
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
