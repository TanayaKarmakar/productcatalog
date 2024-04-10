package com.app.educative.io.dp.fibonacci;

public class HouseThief {
    private static int maxAmount(int[] houses) {
        int n = houses.length;
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Integer.max(houses[0], houses[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Integer.max(dp[i - 1], houses[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 6, 2, 4};
        int ans = maxAmount(nums);

        System.out.println(ans);
    }
}
