package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 23/04/22
 * @project ds-algo-2021
 */
public class NonDecreasingArrayLeetcode665 {
    private static boolean checkPossibility(int[] nums) {
        if(nums.length <= 1)
            return true;
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int maxLen = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] >= nums[j]) {
                    lis[i] = Integer.max(lis[i], lis[j] + 1);
                }
            }
            maxLen = Integer.max(maxLen, lis[i]);
        }
        return (n - maxLen) <= 1;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,3};

        System.out.println(checkPossibility(nums));

        nums = new int[] {4,2,1};
        System.out.println(checkPossibility(nums));

        nums = new int[] {3,4,2,3};
        System.out.println(checkPossibility(nums));

    }
}
