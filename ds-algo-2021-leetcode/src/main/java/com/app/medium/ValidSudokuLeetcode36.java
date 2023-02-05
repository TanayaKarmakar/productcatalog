package com.app.medium;

/**
 * @author t0k02w6 on 29/01/23
 * @project ds-algo-2021
 */
public class ValidSudokuLeetcode36 {
  private static boolean isValidSudoku(char[][] board) {
    int n = board.length;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(board[i][j] != '.') {
          char num = board[i][j];
          board[i][j] = '$';
          if(!isValid(board, i, j, n, num)) {
            return false;
          }
          board[i][j] = num;
        }
      }
    }
    return true;
  }

  private static boolean isValid(char[][] board, int i, int j, int n, char num) {
    for(int col = 0; col < n; col++) {
      if(board[i][col] == num)
        return false;
    }

    for(int row = 0; row < n; row++) {
      if(board[row][j] == num)
        return false;
    }

    int sqrt = (int)Math.sqrt(n);
    int startRow = i - (i % sqrt);
    int startCol = j - (j % sqrt);

    for(int i1 = startRow; i1 < (startRow + sqrt); i1++) {
      for(int j1 = startCol; j1 < (startCol + sqrt); j1++) {
        if(board[i1][j1] == num)
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

  }
}
