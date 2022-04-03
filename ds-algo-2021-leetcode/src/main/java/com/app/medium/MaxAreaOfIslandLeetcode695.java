package com.app.medium;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class MaxAreaOfIslandLeetcode695 {
    private static int count = 0;

    private static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxVal = 0;

        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    maxVal = Integer.max(maxVal, count);
                    count = 0;
                }
            }
        }
        return maxVal;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j])
            return;
        visited[i][j] = true;
        count++;
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int ans = maxAreaOfIsland(grid);

        System.out.println(ans);
    }
}
