package com.app.educative.io.dp.fibonacci;

import java.util.Arrays;

public class MinimumJumpsToReachEnd {
    private static int minJumps(int[] jumps) {
        int n = jumps.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i < n; i++) {
            int result = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                if(j + jumps[j] >= i) {
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
        int[] nums = {2,1,1,1,4};
        int ans = minJumps(nums);

        System.out.println(ans);
    }
}
