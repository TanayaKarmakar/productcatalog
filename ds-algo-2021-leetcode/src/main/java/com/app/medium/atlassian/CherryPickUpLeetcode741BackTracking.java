package com.app.medium.atlassian;

// video - https://www.youtube.com/watch?v=juJ0j-Otgko
public class CherryPickUpLeetcode741BackTracking {
    private static int maxCherryPickedUp = 0;
    private static int cherryPickup(int[][] grid) {
        maxCherryPickedUp = 0;
        pickCherryFromTopToBottom(grid, 0, 0, 0);
        return maxCherryPickedUp;
    }

    private static void pickCherryFromTopToBottom(int[][] grid, int i, int j, int cherryCollectedSoFar) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1)
            return;
        if(i == grid.length - 1 && j == grid[0].length - 1) {
            pickCherryFromBottomToTop(grid, i, j, cherryCollectedSoFar);
        }

        int cherries = grid[i][j];
        grid[i][j] = 0;
        pickCherryFromTopToBottom(grid, i + 1, j, cherryCollectedSoFar + cherries);
        pickCherryFromTopToBottom(grid, i, j + 1, cherryCollectedSoFar + cherries);
        grid[i][j] = cherries;
    }

    private static void pickCherryFromBottomToTop(int[][] grid, int i, int j, int cherryCollectedSoFar) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1)
            return;
        if(i == 0 && j == 0) {
            maxCherryPickedUp = Integer.max(maxCherryPickedUp, cherryCollectedSoFar);
            return;
        }

        int cherries = grid[i][j];
        grid[i][j] = 0;
        pickCherryFromBottomToTop(grid, i - 1, j, cherryCollectedSoFar + cherries);
        pickCherryFromBottomToTop(grid, i, j - 1, cherryCollectedSoFar + cherries);
        grid[i][j] = cherries;
    }


    public static void main(String[] args) {
        int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
        int ans = cherryPickup(grid);

        System.out.println(ans);
    }
}
