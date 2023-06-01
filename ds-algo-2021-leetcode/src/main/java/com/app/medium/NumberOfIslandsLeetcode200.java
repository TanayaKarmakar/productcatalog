package com.app.medium;

/**
 * @author t0k02w6 on 31/05/23
 * @project ds-algo-2021-leetcode
 */
public class NumberOfIslandsLeetcode200 {
  private static int numIslands(char[][] grid) {
    int nIslands = 0;
    int m = grid.length;
    int n = grid[0].length;

    boolean[][] visited = new boolean[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(grid[i][j] == '1' && !visited[i][j]) {
          dfs(grid, visited, i, j, m, n);
          nIslands++;
        }
      }
    }
    return nIslands;
  }

  private static void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
    if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0')
      return;
    visited[i][j] = true;
    dfs(grid, visited, i - 1, j, m, n);
    dfs(grid, visited, i + 1, j, m, n);
    dfs(grid, visited, i, j - 1, m, n);
    dfs(grid, visited, i, j + 1, m, n);
  }

  public static void main(String[] args) {
    char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

    int ans = numIslands(grid);

    System.out.println(ans);
  }
}
