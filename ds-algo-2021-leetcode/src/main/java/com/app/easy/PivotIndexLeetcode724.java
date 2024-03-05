package com.app.easy;

public class PivotIndexLeetcode724 {
    private static int pivotIndex(int[] nums) {
        int left = 0;

        int right = 0;
        for(int i = 0; i < nums.length; i++) {
            right += nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            right = right - nums[i];
            if(left == right)
                return i;
            left = left + nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
