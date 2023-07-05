package com.app.medium.design;

/**
 * @author t0k02w6 on 19/06/23
 * @project ds-algo-2021-leetcode
 */
class TicTacToe {
  int[][] board;
  int boardSize;

  public TicTacToe(int n) {
    this.board = new int[n][n];
    this.boardSize = n;
  }

  public int move(int row, int col, int player) {
    board[row][col] = player;
    boolean hasWon = hasOwn(row, col, player);
    if(hasWon)
      return player;
    return 0;
  }

  private boolean hasOwn(int row, int col, int player) {
    boolean hasOwn = true;
    for(int i = 0; i < boardSize; i++) {
      if(board[row][i] != player) {
        hasOwn = false;
        break;
      }
    }

    if(hasOwn)
      return true;

    hasOwn = true;
    for(int i = 0; i < boardSize; i++) {
      if(board[i][col] != player) {
        hasOwn = false;
        break;
      }
    }

    if(hasOwn)
      return true;

    hasOwn = true;
    for(int i = 0; i < boardSize; i++) {
      if(board[i][i] != player) {
        hasOwn = false;
        break;
      }
    }

    if(hasOwn)
      return true;

    hasOwn = true;
    int j = boardSize - 1;
    int i = 0;
    while(i < boardSize && j >= 0) {
      if(board[i][j] != player) {
        hasOwn = false;
        break;
      }
      i++;
      j--;
    }
    return hasOwn;
  }
}

public class DesignTicTacToeLeetcode348 {
  public static void main(String[] args) {

  }
}
