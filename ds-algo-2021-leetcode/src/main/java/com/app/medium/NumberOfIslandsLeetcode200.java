package com.app.medium;

/**
 * @author t0k02w6 on 06/10/21
 * @project ds-algo-2021
 */
public class NumberOfIslandsLeetcode200 {
    private static void findIsLand(char[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != '1')
            return;
        visited[i][j] = true;
        findIsLand(grid, visited, i - 1, j);
        findIsLand(grid, visited, i + 1, j);
        findIsLand(grid, visited, i, j - 1);
        findIsLand(grid, visited, i, j + 1);
    }

    private static int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    findIsLand(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        int ans = numIslands(grid);

        System.out.println(ans);

    }
}
