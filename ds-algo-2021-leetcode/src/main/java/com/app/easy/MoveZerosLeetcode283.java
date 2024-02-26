package com.app.easy;

import java.util.Arrays;

public class MoveZerosLeetcode283 {
    private static void moveZeroes(int[] nums) {
        int i = -1;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != 0) {
                i++;
                swap(nums, i, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}
