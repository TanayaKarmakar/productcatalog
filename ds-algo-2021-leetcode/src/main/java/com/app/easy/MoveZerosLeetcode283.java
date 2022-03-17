package com.app.easy;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
public class MoveZerosLeetcode283 {
    private static void moveZeroes(int[] nums) {
        int i = -1;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != 0) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
