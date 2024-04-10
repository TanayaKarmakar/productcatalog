package com.app.educative.io.dp.fibonacci;

public class MinimumJumpsWithFee {
    private static int jumpsWithFee(int n, int[] fees) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = fees[0];
        dp[2] = dp[3] = fees[0];

        for(int i = 3; i < n; i++) {
            dp[i + 1] = Integer.min(fees[i] + dp[i], Integer.min(fees[i - 1] + dp[i - 1],
                    fees[i - 2] + dp[i - 2]));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] fees = {1,2,5,2,1,2};
        int n = 6;
        int ans = jumpsWithFee(n, fees);

        System.out.println(ans);
    }
}
