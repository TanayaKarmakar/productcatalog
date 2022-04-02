package com.app.medium;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class MaximalSquareLeetcode221 {
    private static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int maxVal = 0;
        for(int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxVal = Integer.max(maxVal, dp[i][0]);
        }

        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            maxVal = Integer.max(maxVal, dp[0][i]);
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '1') {
                    int option1 = dp[i - 1][j];
                    int option2 = dp[i][j - 1];
                    int option3 = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Integer.min(option1, Integer.min(option2, option3));
                    maxVal = Integer.max(maxVal, dp[i][j]);
                }
            }
        }
        return maxVal * maxVal;
    }

    public static void main(String[] args) {

    }
}
