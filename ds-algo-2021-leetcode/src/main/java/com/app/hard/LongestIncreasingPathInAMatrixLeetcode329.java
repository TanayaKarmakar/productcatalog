package com.app.hard;

public class LongestIncreasingPathInAMatrixLeetcode329 {
    private static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int maxLen = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] == 0) {
                    int ans = dfs(matrix, dp, i, j, m, n, Integer.MIN_VALUE);
                    maxLen = Integer.max(maxLen, ans);
                }
            }
        }
        return maxLen;
    }

    private static int dfs(int[][] matrix, int[][] dp, int i, int j, int m, int n, int prev) {
        if(i < 0 || i >= m || j < 0 || j >= n || prev >= matrix[i][j])
            return 0;
        if(dp[i][j] != 0)
            return dp[i][j];
        int top = dfs(matrix, dp, i - 1, j, m, n, matrix[i][j]);
        int down = dfs(matrix, dp, i + 1, j, m, n, matrix[i][j]);
        int left = dfs(matrix, dp, i, j - 1, m, n, matrix[i][j]);
        int right = dfs(matrix, dp, i, j + 1, m, n, matrix[i][j]);
        int max1 = Integer.max(top, down);
        int max2 = Integer.max(left, right);
        dp[i][j] = 1 + Integer.max(max1, max2);
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};

        int ans = longestIncreasingPath(matrix);

        System.out.println(ans);
    }
}
