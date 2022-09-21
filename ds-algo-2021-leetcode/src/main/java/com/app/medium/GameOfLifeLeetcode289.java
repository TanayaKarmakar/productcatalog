package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class GameOfLifeLeetcode289 {
    private static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{-1,1},{1,-1}};

    private static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = 0;
                for(int k = 0; k < directions.length; k++) {
                    int newRow = i + directions[k][0];
                    int newCol = j + directions[k][1];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                        continue;
                    if(board[newRow][newCol] == 1)
                        count++;
                }
                //System.out.println(count);
                if(board[i][j] == 1) {
                    if(count == 2 || count == 3)
                        newBoard[i][j] = 1;
                } else {
                    if(count == 3)
                        newBoard[i][j] = 1;
                }
            }
        }


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(grid);


        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
