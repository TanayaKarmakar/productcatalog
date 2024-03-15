package com.app.educative.io.dp.boundedknapsack;

public class CountOfSubsetSum {
    private static int countOfSubsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n][sum + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= sum; i++) {
            if(i == nums[0]) {
                dp[0][i] = 1;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][sum];
    }

    public static void main(String[] args) {
        System.out.println(countOfSubsets(new int[]{1,1,2,3}, 4));
    }
}
