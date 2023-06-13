package com.app.medium;

/**
 * @author t0k02w6 on 06/06/23
 * @project ds-algo-2021-leetcode
 */
public class WordSearchLeetcode79 {
  private static boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(board[i][j] == word.charAt(0)) {
          if(isFound(board, word, visited, i, j, 0))
            return true;
        }
      }
    }
    return false;
  }

  private static boolean isFound(char[][] board, String word, boolean[][] visited, int i, int j, int indx) {
    if(indx == word.length())
      return true;
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(indx) != board[i][j])
      return false;
    visited[i][j] = true;
    boolean isFound = isFound(board, word, visited, i - 1, j, indx + 1);
    isFound |= isFound(board, word, visited, i + 1, j, indx + 1);
    isFound |= isFound(board, word, visited, i, j - 1, indx + 1);
    isFound |= isFound(board, word, visited, i, j + 1, indx + 1);
    visited[i][j] = false;
    return isFound;
  }

  public static void main(String[] args) {

  }
}
