package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 10/06/23
 * @project ds-algo-2021-leetcode
 */
public class GameOfLifeLeetcode289 {
  private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};

  private static void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;

    int[][] tmp = new int[m][n];
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
        if(board[i][j] == 1) {
          if(count == 2 || count == 3) {
            tmp[i][j] = 1;
          }
        } else {
          if(count == 3)
            tmp[i][j] = 1;
        }
      }
    }

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        board[i][j] = tmp[i][j];
      }
    }
  }

  public static void main(String[] args) {
    int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

    gameOfLife(board);

    for(int i = 0; i < board.length; i++) {
      System.out.println(Arrays.toString(board[i]));
    }
  }
}
