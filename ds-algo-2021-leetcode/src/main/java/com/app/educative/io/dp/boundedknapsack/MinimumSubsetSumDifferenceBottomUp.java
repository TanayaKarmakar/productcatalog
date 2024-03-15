package com.app.educative.io.dp.boundedknapsack;

public class MinimumSubsetSumDifferenceBottomUp {
    private static int calculateMinimumDifference(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }

        int targetSum = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][targetSum + 1];
        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for(int j = 1; j <= targetSum; j++) {
            if(j == nums[0])
                dp[0][j] = true;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j];

                if(j >= nums[i]) {
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
            }
        }

        int sum1 = 0;
        for(int i = targetSum; i >= 0; i--) {
            if(dp[n - 1][i]) {
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumDifference(new int[]{1, 2, 3, 9}));
        System.out.println(calculateMinimumDifference(new int[]{1, 2, 7, 1, 5}));
        System.out.println(calculateMinimumDifference(new int[]{1, 3, 100, 4}));
    }
}
