package com.app.educative.io.dp.boundedknapsack;

public class SubsetSum {
    private static boolean isSubsetExists(int[] nums, int targetSum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][targetSum + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= targetSum; i++) {
            if(i == nums[0]) {
                dp[0][i] = true;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j];

                if(j >= nums[i])
                    dp[i][j] |= dp[i - 1][j - nums[i]];
            }
        }
        return dp[n - 1][targetSum];
    }

    public static void main(String[] args) {

    }
}
