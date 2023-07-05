package com.app.medium;

/**
 * @author t0k02w6 on 25/06/23
 * @project ds-algo-2021-leetcode
 */
public class BattleshipsOnABoardLeetcode419 {
  private static int countBattleships(char[][] board) {
    int count = 0;
    int m = board.length;
    int n = board[0].length;
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(board[i][j] == 'X') {
          if((i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X'))
            continue;
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'},{'.','.','.','.'}};

    int ans = countBattleships(board);

    System.out.println(ans);
  }
}
