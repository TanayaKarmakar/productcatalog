package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */
public class LongestIncreasingSubsequenceLeetcode300 {
    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int maxLen = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Integer.max(dp[i], maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
