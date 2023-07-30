package com.app.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 09/07/23
 * @project ds-algo-2021-leetcode
 */
public class NumberOfDistinctIslandsLeetcode694 {
  private static int numDistinctIslands(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    Set<String> isLands = new HashSet<>();

    boolean[][] visited = new boolean[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(grid[i][j] == 1 && !visited[i][j]) {
          StringBuilder sb = new StringBuilder();
          dfs(grid, visited, i, j, sb, ".");
          isLands.add(sb.toString());
        }
      }
    }
    return isLands.size();
  }

  private static void dfs(int[][] grid, boolean[][] visited, int i, int j, StringBuilder sb, String fragment) {
    if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)
      return;
    visited[i][j] = true;
    sb.append(fragment);
    dfs(grid, visited, i - 1, j, sb, "U");
    dfs(grid, visited, i + 1, j, sb, "D");
    dfs(grid, visited, i, j - 1, sb, "L");
    dfs(grid, visited, i, j + 1, sb, "R");
    sb.append("/");
  }

  public static void main(String[] args) {
    int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};

    int ans = numDistinctIslands(grid);

    System.out.println(ans);
  }
}
