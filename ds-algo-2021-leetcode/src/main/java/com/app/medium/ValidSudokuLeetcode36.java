package com.app.medium;

/**
 * @author t0k02w6 on 05/06/23
 * @project ds-algo-2021-leetcode
 */
public class ValidSudokuLeetcode36 {
  private static boolean isValidSudoku(char[][] board) {
    int n = board.length;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(board[i][j] != '.') {
          char num = board[i][j];
          board[i][j] = '$';
          if(!isValid(board, i, j, num))
            return false;
          board[i][j] = num;
        }
      }
    }
    return true;
  }

  private static boolean isValid(char[][] board, int i, int j, char num) {
    for(int row = 0; row < board.length; row++) {
      if(board[row][j] == num)
        return false;
    }

    for(int col = 0; col < board[0].length; col++) {
      if(board[i][col] == num)
        return false;
    }

    int startRow = i - (i % 3);
    int startCol = j - (j % 3);
    for(int row = startRow; row < startRow + 3; row++) {
      for(int col = startCol; col < startCol + 3; col++) {
        if(board[row][col] == num)
          return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {

  }
}
