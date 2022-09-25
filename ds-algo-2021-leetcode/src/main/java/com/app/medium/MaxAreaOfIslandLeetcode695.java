package com.app.medium;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class MaxAreaOfIslandLeetcode695 {
    private static int count = 0;

    private static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxCount = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(grid, visited, i, j, m, n);
                    maxCount = Integer.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0)
            return;
        visited[i][j] = true;
        count++;
        dfs(grid, visited, i - 1, j, m, n);
        dfs(grid, visited, i + 1, j, m, n);
        dfs(grid, visited, i, j - 1, m, n);
        dfs(grid, visited, i, j + 1, m, n);
    }

    public static void main(String[] args) {

    }
}
