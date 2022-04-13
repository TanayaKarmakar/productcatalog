package com.app.medium;

/**
 * @author t0k02w6 on 12/04/22
 * @project ds-algo-2021
 */
public class PartitionEqualSubsetSumLeetcode416 {
    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0)
            return false;
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= target; j++) {
                boolean val = dp[i - 1][j];
                if(j >= nums[i - 1]) {
                    val = val | dp[i - 1][j - nums[i - 1]];
                }
                dp[i][j] = val;
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean ans = canPartition(nums);

        System.out.println(ans);
    }
}
