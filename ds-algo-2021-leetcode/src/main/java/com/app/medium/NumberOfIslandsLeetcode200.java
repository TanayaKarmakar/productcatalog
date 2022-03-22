package com.app.medium;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
public class NumberOfIslandsLeetcode200 {
    private static void traverse(char[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        traverse(grid, visited, i - 1, j);
        traverse(grid, visited, i + 1, j);
        traverse(grid, visited, i, j - 1);
        traverse(grid, visited, i, j + 1);
    }

    private static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    traverse(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        int ans = numIslands(grid);

        System.out.println(ans);
    }
}
