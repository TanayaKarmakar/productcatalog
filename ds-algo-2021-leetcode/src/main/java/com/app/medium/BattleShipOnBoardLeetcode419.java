package com.app.medium;

/**
 * @author t0k02w6 on 09/05/23
 * @project ds-algo-2021-leetcode
 */
public class BattleShipOnBoardLeetcode419 {
  private static int countBattleships(char[][] board) {
    int m = board.length;
    int n = board[0].length;

    int count = 0;
    for(int r = 0; r < m; r++) {
      for(int c = 0; c < n; c++) {
        if(board[r][c] == 'X') {
          if((r > 0 && board[r - 1][c] == 'X') || (c > 0 && board[r][c - 1] == 'X'))
            continue;
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    char[][] board = {{'X', '.', '.', 'X'},{'.','.','.','X'},{'.','.','.','X'},{'.','.','.','.'}};
    int ans = countBattleships(board);
    System.out.println(ans);
  }
}
