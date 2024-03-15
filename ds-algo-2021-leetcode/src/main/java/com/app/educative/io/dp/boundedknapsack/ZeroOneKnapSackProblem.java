package com.app.educative.io.dp.boundedknapsack;

public class ZeroOneKnapSackProblem {
    private static int findMaxProfit(int[] weights, int[] profits, int maxCapacity) {
        int n = weights.length;
        int[][] dp = new int[n][maxCapacity + 1];

        for(int i = 0; i <= maxCapacity; i++) {
            if(i >= weights[0]) {
                dp[0][i] = profits[0];
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= maxCapacity; j++) {
                int profit1 = dp[i - 1][j];
                int profit2 = 0;
                if(j >= weights[i]) {
                    profit2 = profits[i] + dp[i - 1][j - weights[i]];
                }
                dp[i][j] = Integer.max(profit1, profit2);
            }
        }
        printWeights(dp, weights, profits, maxCapacity);
        return dp[n - 1][maxCapacity];
    }

    private static void printWeights(int[][] dp, int[] weights, int[] profits, int maxCapacity) {
        int n = weights.length;
        int calculatedMaxProfit = dp[n - 1][maxCapacity];
        for(int i = n - 1; i > 0; i--) {
            if(calculatedMaxProfit != dp[i - 1][maxCapacity]) {
                System.out.println("Weights : " + weights[i] + " --> Profits : " + profits[i]);
                maxCapacity -= weights[i];
                calculatedMaxProfit -= profits[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 5};
        int[] profits = {1, 6, 10, 16};
        int maxCapacity = 7;


        int ans = findMaxProfit(weights, profits, maxCapacity);
        System.out.println("*************************");
        System.out.println(ans);
    }
}
