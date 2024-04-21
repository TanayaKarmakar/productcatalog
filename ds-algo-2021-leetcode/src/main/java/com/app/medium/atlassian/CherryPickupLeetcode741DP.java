package com.app.medium.atlassian;

public class CherryPickupLeetcode741DP {
    private static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][][] dp = new int[n][n][n][n];

        return collectMaxCherries(grid, 0, 0, 0, 0, dp, n);
    }

    private static int collectMaxCherries(int[][] grid, int r1, int c1, int r2, int c2, int[][][][] dp, int n) {
        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return 0;
        }
        if(r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if(dp[r1][c1][r2][c2] != 0)
            return dp[r1][c1][r2][c2];

        int cherries = 0;
        if(r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += (grid[r1][c1] + grid[r2][c2]);
        }

        int f1 = collectMaxCherries(grid, r1, c1 + 1, r2, c2 + 1, dp, n); //hh
        int f2 = collectMaxCherries(grid, r1 + 1, c1, r2, c2 + 1, dp, n); //vh
        int f3 = collectMaxCherries(grid, r1, c1 + 1, r2 + 1, c2, dp, n); //hv
        int f4 = collectMaxCherries(grid, r1 + 1, c1, r2 + 1, c2, dp, n); //vv
        cherries += Integer.max(Integer.max(f1, f2), Integer.max(f3, f4));
        dp[r1][c1][r2][c2] = cherries;
        return cherries;
    }


    public static void main(String[] args) {
        int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
        int ans = cherryPickup(grid);

        System.out.println(ans);
    }
}
