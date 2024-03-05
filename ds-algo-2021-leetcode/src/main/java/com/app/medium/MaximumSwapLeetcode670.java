package com.app.medium;

public class MaximumSwapLeetcode670 {
    private static int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();

        int max = num;
        int n = nums.length;

        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] < nums[j]) {
                    swap(nums, i, j);
                    max = Integer.max(max, Integer.parseInt(new String(nums)));
                    swap(nums, i, j);
                }
            }
        }
        return max;
    }

    private static void swap(char[] nums, int i, int j) {
        char ch = nums[i];
        nums[i] = nums[j];
        nums[j] = ch;
    }

    public static void main(String[] args) {

    }
}
