package com.app.medium;

public class NumberOfIslandsLeetcode200 {
    private static int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || visited[i][j])
            return;
        visited[i][j] = true;
        bfs(grid, visited, i - 1, j, m, n);
        bfs(grid, visited, i + 1, j, m, n);
        bfs(grid, visited, i, j - 1, m, n);
        bfs(grid, visited, i, j + 1, m, n);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        int count = numIslands(grid);

        System.out.println(count);
    }
}
