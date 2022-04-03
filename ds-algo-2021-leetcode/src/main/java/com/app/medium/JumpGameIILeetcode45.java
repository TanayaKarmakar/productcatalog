package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class JumpGameIILeetcode45 {
    private static int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                if(j + nums[j] >= i) {
                    min = Integer.min(min, dp[j]);
                }
            }
            if(min != Integer.MAX_VALUE)
                dp[i] = Integer.min(dp[i], 1 + min);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int ans = jump(nums);

        System.out.println(ans);
    }
}
