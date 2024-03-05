package com.app.easy;

public class MissingNumberLeetcode268 {
    private static int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 1; i <= nums.length; i++) {
            sum += i;
        }

        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
        }
        return (sum - currentSum);
    }

    public static void main(String[] args) {

    }
}
