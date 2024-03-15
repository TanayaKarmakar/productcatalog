package com.app.educative.io.dp.boundedknapsack;

public class TargetSum {
    private static int numWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }

        if((totalSum + target) % 2 != 0)
            return 0;
        target = (totalSum + target) / 2;
        int n = nums.length;

        int[][] dp = new int[n][target + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= target; i++) {
            if(i == nums[0]) {
                dp[0][i] = 1;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if(j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        int S = 1;

        int ans = numWays(nums, S);

        System.out.println(ans);
    }
}
