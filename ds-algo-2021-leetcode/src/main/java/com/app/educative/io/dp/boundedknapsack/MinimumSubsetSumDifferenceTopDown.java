package com.app.educative.io.dp.boundedknapsack;

public class MinimumSubsetSumDifferenceTopDown {
    private static int canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        int n = nums.length;
        Integer[][] dp = new Integer[n][sum + 1];
        return canPartitionRec(nums, dp, 0, 0,0);
    }

    private static int canPartitionRec(int[] nums, Integer[][] dp, int indx, int sum1, int sum2) {
        if(indx >= nums.length) {
            return Math.abs(sum1 - sum2);
        }

        if(dp[indx][sum1] == null) {
            int diff1 = canPartitionRec(nums, dp, indx + 1, nums[indx] + sum1, sum2);
            int diff2 = canPartitionRec(nums, dp, indx + 1, sum1, sum2 + nums[indx]);
            dp[indx][sum1] = Integer.min(diff1, diff2);
        }
        return dp[indx][sum1];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 9}));
    }
}
