package com.app.educative.io.dp.boundedknapsack;

public class EqualSubsetSumPartition {
    private static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }

        if(totalSum % 2 != 0)
            return false;
        int targetSum = totalSum / 2;
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
                if(j >= nums[i]) {
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][targetSum];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 4 }));
        System.out.println(canPartition(new int[]{1, 1, 3, 4, 7 }));
        System.out.println(canPartition(new int[]{2, 3, 4, 6}));
    }
}
