package com.app.medium;

public class MaxAreaOfIslandsLeetcode695 {
    private static int maxArea = 0;
    private static int currentArea = 0;

    private static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    currentArea = 0;
                    calculateArea(grid, visited, i, j, m, n);
                    maxArea = Integer.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }

    private static void calculateArea(int[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] != 1)
            return;
        visited[i][j] = true;
        currentArea++;
        calculateArea(grid, visited, i - 1, j, m, n);
        calculateArea(grid, visited, i + 1, j, m, n);
        calculateArea(grid, visited, i, j - 1, m, n);
        calculateArea(grid, visited, i, j + 1, m, n);
    }

    public static void main(String[] args) {

    }
}
