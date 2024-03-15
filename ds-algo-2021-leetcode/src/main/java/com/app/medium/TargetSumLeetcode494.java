package com.app.medium;

public class TargetSumLeetcode494 {
    private static int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }
        if(totalSum < target)
            return 0;

        if((totalSum + target) % 2 != 0)
            return 0;
        int targetSum = (totalSum + target)/2;
        int n = nums.length;

        int[][] dp = new int[n][targetSum + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 0; i <= targetSum; i++) {
            if(i == nums[0])
                dp[0][i] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j];

                if(j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][targetSum];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int targetSum = 3;

        int ans = findTargetSumWays(nums, targetSum);
        System.out.println(ans);
    }
}
