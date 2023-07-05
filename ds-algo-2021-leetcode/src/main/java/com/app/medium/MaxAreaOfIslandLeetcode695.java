package com.app.medium;

/**
 * @author t0k02w6 on 15/06/23
 * @project ds-algo-2021-leetcode
 */
public class MaxAreaOfIslandLeetcode695 {
  private static int currentCount = 0;

  private static int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];

    int maxCount = 0;
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(!visited[i][j] && grid[i][j] == 1) {
          currentCount = 0;
          dfs(grid, visited, i, j, m, n);
          maxCount = Integer.max(maxCount, currentCount);
        }
      }
    }
    return maxCount;
  }

  private static void dfs(int[][] grid, boolean[][] visited, int i, int j, int m, int n) {
    if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0)
      return;
    currentCount++;
    visited[i][j] = true;
    dfs(grid, visited, i - 1, j, m, n);
    dfs(grid, visited, i + 1, j, m, n);
    dfs(grid, visited, i, j - 1, m, n);
    dfs(grid, visited, i, j + 1, m, n);
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
