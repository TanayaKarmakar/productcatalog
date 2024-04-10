package com.app.educative.io.dp.fibonacci;

public class StairCaseProblem {
    private static int totalWays(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            int option1 = dp[i - 1];
            int option2 = dp[i - 2];
            int option3 = dp[Integer.max(0, i - 3)];
            dp[i] = option1 + option2 + option3;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        int ans = totalWays(n);

        System.out.println(ans);
    }
}
