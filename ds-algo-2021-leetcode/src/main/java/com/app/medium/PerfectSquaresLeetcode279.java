package com.app.medium;

public class PerfectSquaresLeetcode279 {
    private static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int sqrt = (int)Math.sqrt(n);

        for(int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= sqrt; j++) {
                if(j * j == i)
                    dp[i] = 1;
                else if(i >= (j * j)) {
                    dp[i] = Integer.min(dp[i], 1 + dp[i - (j * j)]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }
}
