package com.app.easy;

public class MaximumProductsOfTwoElementInAnArrayLeetcode1464 {
    private static int maxProduct(int[] nums) {
        int firstMax = 0;
        int secondMax = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
            } else if(nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return (firstMax - 1) * (secondMax - 1);
    }
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3,4,5,2}));
    }
}
