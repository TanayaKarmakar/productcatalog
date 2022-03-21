package com.app.easy;

import java.util.Arrays;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class ArrayPartitionLeetcode561 {
    private static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for(int i = 0; i < nums.length; i += 2) {
            sum += Integer.min(nums[i], nums[i + 1]);
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
