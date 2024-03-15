package com.app.medium;

public class PartitionEqualSubsetSumLeetcode416 {
    private static boolean canPartition(int[] nums) {
        int totalPartition = 0;
        for(int i = 0; i < nums.length; i++) {
            totalPartition += nums[i];
        }

        if(totalPartition % 2 != 0)
            return false;

        int targetSum = totalPartition / 2;
        boolean[][] dp = new boolean[nums.length][targetSum + 1];

        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for(int i = 0; i <= targetSum; i++) {
            if(nums[0] == i)
                dp[0][i] = true;
        }

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i]) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][targetSum];
    }

    public static void main(String[] args) {

    }
}
