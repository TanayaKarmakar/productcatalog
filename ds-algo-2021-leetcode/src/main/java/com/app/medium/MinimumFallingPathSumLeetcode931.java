package com.app.medium;

public class MinimumFallingPathSumLeetcode931 {
    private static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int ans = findPrevColValue(dp, i - 1, j);
                dp[i][j] = matrix[i][j] + ans;
            }
        }

        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            minValue = Integer.min(minValue, dp[m - 1][i]);
        }
        return minValue;
    }

    private static int findPrevColValue(int[][] dp, int prevRow, int currCol) {
        int option1 = currCol - 1 >= 0 ? dp[prevRow][currCol - 1]: Integer.MAX_VALUE;
        int option2 = dp[prevRow][currCol];
        int option3 = currCol + 1 < dp[0].length ? dp[prevRow][currCol + 1]: Integer.MAX_VALUE;
        return Integer.min(option1, Integer.min(option2, option3));
    }


    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int ans = minFallingPathSum(matrix);

        System.out.println(ans);
    }
}
