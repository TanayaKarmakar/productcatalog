package com.app.medium;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class MinimumFallingPathLeetcode931 {
    private static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int option1 = (j - 1) >= 0 ? dp[i - 1][j - 1]: Integer.MAX_VALUE;
                int option2 = dp[i - 1][j];
                int option3 = (j + 1) < n ? dp[i - 1][j + 1]: Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Integer.min(option1, Integer.min(option2, option3));
            }
        }

        int finalAns = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            finalAns = Integer.min(finalAns, dp[m - 1][i]);
        }

        return finalAns;
    }

    public static void main(String[] args) {
        int[][] dp = {{2,1,3},{6,5,4},{7,8,9}};

        int ans = minFallingPathSum(dp);

        System.out.println(ans);
    }
}
