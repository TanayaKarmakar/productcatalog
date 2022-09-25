package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class JumpGameIILeetcode45 {
    private static int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        for(int i = 1; i < n; i++) {
            int res = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                if(j + nums[j] >= i) {
                    res = Integer.min(res, dp[j]);
                }
            }
            if(res != Integer.MAX_VALUE) {
                dp[i] = res + 1;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {

    }
}
