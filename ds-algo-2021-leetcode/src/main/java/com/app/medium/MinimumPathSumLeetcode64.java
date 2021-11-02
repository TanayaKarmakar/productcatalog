package com.app.medium;

/**
 * @author t0k02w6 on 31/10/21
 * @project ds-algo-2021
 */
public class MinimumPathSumLeetcode64 {
    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minPath = new int[m][n];

        minPath[0][0] = grid[0][0];
        for(int i = 1; i < m; i++) {
            minPath[i][0] = grid[i][0] + minPath[i - 1][0];
        }

        for(int i = 1; i < n; i++) {
            minPath[0][i] = grid[0][i] + minPath[0][i - 1];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                minPath[i][j] = grid[i][j] + Integer.min(minPath[i - 1][j], minPath[i][j - 1]);
            }
        }

        return minPath[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int ans = minPathSum(grid);

        System.out.println(ans);
    }
}
