package com.app.medium;

public class ProductOfArrayExceptSelfLeetcode238 {
    private static int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        int leftVal = 1;
        for(int i = 0; i < n; i++) {
            temp[i] = leftVal;
            leftVal = nums[i] * leftVal;
        }

        int rightVal = 1;
        for(int i = n - 1; i >= 0; i--) {
            temp[i] = temp[i] * rightVal;
            rightVal = rightVal * nums[i];
        }

        return temp;
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int leftVal = 1;
        for(int i = 0; i < n; i++) {
            left[i] = leftVal;
            leftVal = leftVal * nums[i];
        }

        int rightVal = 1;
        for(int i = n - 1; i >= 0; i--) {
            right[i] = rightVal;
            rightVal = rightVal * nums[i];
        }

        for(int i = 0; i < n; i++) {
            left[i] = left[i] * right[i];
        }

        return left;
    }

    public static void main(String[] args) {

    }
}
