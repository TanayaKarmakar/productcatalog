package com.app.easy;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
public class PivotIndexLeetcode724 {
    private static int pivotIndex(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int left = 0;
        int right = total;
        for(int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if(left == right)
                return i;
            left += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
