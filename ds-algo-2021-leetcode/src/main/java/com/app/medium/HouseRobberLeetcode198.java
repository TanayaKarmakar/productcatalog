package com.app.medium;

public class HouseRobberLeetcode198 {
    private static int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        int ans = rob(nums);

        System.out.println(ans);
    }
}
