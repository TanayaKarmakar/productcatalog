package com.app.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */
public class NumberOfDistinctIslandsLeetcode694 {

  private static int numDistinctIslands(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    //boolean[][] visited = new boolean[m][n];
    StringBuilder sb = new StringBuilder();
    Set<String> islands = new HashSet<>();
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(grid[i][j] == 1) {
          sb = new StringBuilder();
          dfs(grid, i, j, sb, ".");
          islands.add(sb.toString());
        }
      }
    }
    return islands.size();
  }

  private static void dfs(int[][] grid, int i, int j, StringBuilder sb, String fragment) {
    if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
      return;
    sb.append(fragment);
    grid[i][j] = 0;
    dfs(grid, i - 1, j, sb, "U");
    dfs(grid, i + 1, j, sb, "D");
    dfs(grid, i, j - 1, sb, "L");
    dfs(grid, i, j + 1, sb, "R");
    sb.append("/");
  }

  public static void main(String[] args) {
      int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
      int ans = numDistinctIslands(grid);

    System.out.println(ans);
  }
}
