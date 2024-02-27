package com.app.medium;

import java.util.Arrays;

public class RotateArrayLeetcode189 {
    private static void rotate(int[] nums, int k) {
        if(nums.length < k)
            k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }
}
