package com.app.medium;

import java.util.Arrays;

public class JumpGameIILeetcode45 {
    private static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i < n; i++) {
            int result = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                if(j + nums[j] >= i) {
                    result = Integer.min(result, dp[j]);
                }
            }
            if(result != Integer.MAX_VALUE) {
                dp[i] = result + 1;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {

    }
}
