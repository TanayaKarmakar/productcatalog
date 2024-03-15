package com.app.medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslandsLeetcode694 {
    private static int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> islands = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, visited, i, j, m, n, sb, ".");
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j, int m, int n, StringBuilder sb, String fragment) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0)
            return;
        sb.append(fragment);
        visited[i][j] = true;
        dfs(grid,visited, i - 1,j,m,n,sb,"U");
        dfs(grid,visited, i + 1,j,m,n,sb,"D");
        dfs(grid,visited, i, j - 1,m,n,sb,"L");
        dfs(grid,visited,i,j + 1,m,n,sb,"R");
        sb.append("/");
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int ans = numDistinctIslands(grid);

        System.out.println(ans);
    }
}
